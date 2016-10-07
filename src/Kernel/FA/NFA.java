package Kernel.FA;

import java.util.ArrayList;

/**
 * Created by Bill on 2016/10/2.
 */
public class NFA {
    node startState, AcceptState;

    public NFA(String now){
        startState = new node();
        AcceptState = new node();
        new edge(startState, AcceptState,now);
    }

    public NFA(node _startState,node _AcceptState){
        startState = _startState;
        AcceptState = _AcceptState;
    }

    public NFA(NFA sub1, NFA sub2, char op){
        if (op == '&') {
            startState = sub1.startState;
            AcceptState = sub2.AcceptState;
            new edge(sub1.AcceptState,sub2.startState," ");
        }
        else if (op == '|'){
            startState = new node();
            AcceptState = new node();
            new edge(startState,sub1.startState," ");
            new edge(startState,sub2.startState," ");
            new edge(sub1.AcceptState, AcceptState," ");
            new edge(sub2.AcceptState, AcceptState," ");
        }
    }

    public NFA(NFA sub){
        startState = new node();
        AcceptState = new node();
        new edge(startState,sub.startState," ");
        new edge(sub.AcceptState, AcceptState," ");
        new edge(sub.AcceptState,sub.startState," ");
        new edge(startState,AcceptState," ");
    }

    public void tag(){
        ArrayList<node> queue = new ArrayList<>();
        Integer queueHead = 0;
        queue.add(startState);
        while (queueHead < queue.size()) {
            node now = queue.get(queueHead);
            now.name = (queueHead++).toString();
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge){
                if (!nowEdge.tail.getVisit()){
                    queue.add(nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        startState.cleanVisit();
    }

    @Override
    public String toString() {
        String str = "digraph{\n" +
                "\trankdir = LR\n" +
                "\tnode[shape = circle]\n" +
                "\tstart[style = invis]\n" +
                "\tstart->"+ startState.toString() +"[label = start]\n" +
                "\t"+ AcceptState.name +"[shape = doublecircle]\n";
        ArrayList<node> queue = new ArrayList<>();
        int queueHead = 0;
        queue.add(startState);
        while (queueHead < queue.size()) {
            node now = queue.get(queueHead++);
            now.setVisit();
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge) {
                str += '\t' +
                        nowEdge.head.toString() +
                        "->" +
                        nowEdge.tail.toString() +
                        "[label = " +
                        ((nowEdge.name.equals(" ")) ? "ε" : nowEdge.name) +
                        "]\n";
                if (!nowEdge.tail.getVisit()){
                    queue.add(nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        startState.cleanVisit();
        return str + "}";
    }
}
