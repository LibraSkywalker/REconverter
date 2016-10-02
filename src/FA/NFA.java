package FA;

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
            new edge(startState,sub1.startState," ");
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
    }

    public void tag(){
        ArrayList<node> queue = new ArrayList<>();
        int queueHead = 0;
        node now = startState;
        while (now != null) {
            now.name = queueHead;
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
                queue.add(nowEdge.tail);
            now = queue.get(queueHead++);
        }
    }

    @Override
    public String toString() {
        tag();
        String str = "digraph{\n" +
                "\trankdir = LR\n" +
                "\tnode[shape = circle]\n" +
                "\tstart[style = invis]\n" +
                "\tstart->0[label = start]\n" +
                "\t"+ AcceptState.name +"[shape = doublecircle]";
        ArrayList<node> queue = new ArrayList<>();
        int queueHead = 0;
        node now = startState;
        while (now != null) {
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
                str += '\t' +
                        nowEdge.head.name +
                        "->" +
                        nowEdge.tail.name +
                        "[label = " +
                        ((nowEdge.name.equals(" ")) ? nowEdge.name : "ε") +
                        "]\n" ;
            now = queue.get(queueHead++);
        }
        return str + "}";
    }
}
