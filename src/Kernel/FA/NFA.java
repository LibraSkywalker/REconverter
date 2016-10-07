package Kernel.FA;

import java.util.*;

/**
 * Created by Bill on 2016/10/2.
 */
public class NFA implements Iterable<Node>{
    Node startState, AcceptState;

    public NFA(){}

    public NFA(String now){
        startState = new Node();
        AcceptState = new Node();
        new Edge(startState, AcceptState,now);
    }

    public NFA(Node _startState, Node _AcceptState){
        startState = _startState;
        AcceptState = _AcceptState;
    }

    public NFA(NFA sub1, NFA sub2, char op){
        if (op == '&') {
            startState = sub1.startState;
            AcceptState = sub2.AcceptState;
            new Edge(sub1.AcceptState,sub2.startState," ");
        }
        else if (op == '|'){
            startState = new Node();
            AcceptState = new Node();
            new Edge(startState,sub1.startState," ");
            new Edge(startState,sub2.startState," ");
            new Edge(sub1.AcceptState, AcceptState," ");
            new Edge(sub2.AcceptState, AcceptState," ");
        }
    }

    public NFA(NFA sub){
        startState = new Node();
        AcceptState = new Node();
        new Edge(startState,sub.startState," ");
        new Edge(sub.AcceptState, AcceptState," ");
        new Edge(sub.AcceptState,sub.startState," ");
        new Edge(startState,AcceptState," ");
    }

    public void tag(){
        ArrayList<Node> queue = new ArrayList<>();
        Integer name = 0;
        for (Node now : this){
            now.name = (name++).toString();
        }
    }

    @Override
    public String toString() {
        String str = "digraph{\n" +
                "\trankdir = LR\n" +
                "\tNode[shape = circle]\n" +
                "\tstart[style = invis]\n" +
                "\tstart->"+ startState.toString() +"[label = start]\n" +
                "\t"+ AcceptState.name +"[shape = doublecircle]\n";

        for (Node now : this)
            for (Edge nowEdge : now.edges){
                str += '\t' +
                        nowEdge.head.toString() +
                        "->" +
                        nowEdge.tail.toString() +
                        "[label = " +
                        ((nowEdge.name.equals(" ")) ? "ε" : nowEdge.name) +
                        "]\n";
            }

        return str + "}";
    }

    public Iterator<Node> iterator(){
        return new NFAiterator();
    }

    int size(){
        int ans = 0;
            for(Node now : this)
                ans++;
        return ans;
    }

    public DFAnode deal(String name,DFAnode now){
        DFAnode next = new DFAnode();
        for (Node current : now.data){
            for (Edge nowEdge = current.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
                if (nowEdge.name.equals(name))
                    next.add(nowEdge.tail);
        }
        next.floodfill();
        return next;
    }


    Set<Node> expand(Set<Node> origin){
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> ret = new HashSet<>();
        for (Node now : origin){
            ret.add(now);
            queue.add(now);
            now.setVisit();
        }
        while (queue.size() > 0){
            Node now = queue.removeFirst();
            now.setVisit();
            for (Edge nowEdge : now.edges){
                if (nowEdge.name.equals(" ") && !nowEdge.tail.getVisit()) {
                    ret.add(nowEdge.tail);
                    queue.add(nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        for (Node now : ret)
            now.cleanVisit();
        return ret;
    }

    public DFA convert(){
        DFA result = new DFA();
        Set<Node> start = new HashSet<>();
        start.add(startState);
        start = expand(start);
        result.startState = new Node();
        result.put(start,result.startState);

        LinkedList<Set<Node>> queue = new LinkedList<>();
        queue.add(start);

        while (queue.size() > 0){
            Set<Node> now = queue.removeFirst();


            for (String name : nameOfEdge){
                DFAnode next = deal(name,now);
                if (!DFAnodeList.contains(next)){
                    DFAnodeList.add(next);
                    queue.add(next);
                } else {
                    next = DFAnodeList.get(DFAnodeList.indexOf(next));
                }
                new Edge(now,next,name);
            }
        }
        result.tag();
        return result;
    }


    public class NFAiterator implements Iterator{
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        NFAiterator(){
            queue.add(startState);
            visited.add(startState);
        }
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Node next() {
            Node ret = queue.removeFirst();
            for (Edge now : ret.edges)
                if (!visited.contains(now.tail)){
                    queue.add(now.tail);
                    visited.add(now.tail);
                }
            return ret;
        }
    }
}
