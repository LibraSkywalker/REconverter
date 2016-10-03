package FA;

import java.util.*;

/**
 * Created by Bill on 2016/10/2.
 */
public class DFA {
    DFAnode startState;
    NFA prototype;
    ArrayList<DFAnode> Acceptstate = new ArrayList<>();
    Set<String> nameOfEdge = new HashSet<>();
    LinkedList<DFAnode> DFAnodeList = new LinkedList<>();
    public DFA(NFA now){
        prototype = now;
    }

    String AcceptState(){
        String str = "";
            for (DFAnode now : Acceptstate)
                str += "," + now.toString() ;
        return  str.substring(1);
    }

    @Override
    public String toString() {
        //tag();
        String str = "digraph{\n" +
                "\trankdir = LR\n" +
                "\tnode[shape = circle]\n" +
                "\tstart[style = invis]\n" +
                "\tstart->0[label = start]\n" +
                "\t"+ AcceptState() +"[shape = doublecircle]\n";
        LinkedList<DFAnode> queue = new LinkedList<>();
        queue.add(startState);
        while (queue.size() > 0) {
            DFAnode now = queue.removeFirst();
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge) {
                str += '\t' +
                        nowEdge.head.toString() +
                        "->" +
                        nowEdge.tail.toString() +
                        "[label = " +
                        ((nowEdge.name.equals(" ")) ? "ε" : nowEdge.name) +
                        "]\n";
                if (!nowEdge.tail.getVisit()){
                    queue.add((DFAnode) nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        startState.cleanVisit();
        return str + "}";
    }

    public String list(){
        String str = "\\begin{table}[!hbp]\n" +
                "\\begin{tabular}{";
        for (edge nowEdge = startState.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
            str += "|c";

        str += "|c|c|}\n";
        str += "\\hline\n";
        str += "NFA\t\t& DFA\t";
        for (edge nowEdge = startState.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
            str += "& "+ nowEdge.name + "\t";
        str += "\\\\\n";
        str += "\\hline\n";
        LinkedList<DFAnode> queue = new LinkedList<>();
        queue.add(startState);

        while (queue.size() > 0){
            DFAnode now = queue.removeFirst();
            now.setVisit();
            str += now.origin() + "\t" + "& " + now.toString() + "\t";

            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge){
                str += "& " + nowEdge.tail + "\t";
                if (!nowEdge.tail.getVisit()){
                    queue.add((DFAnode) nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
            str += "\\\\\n";
            str += "\\hline\n";
        }
        str += "\\end{tabular}\n" +
                "\\end{table} \n";
        startState.cleanVisit();
        return str;
    }

    public DFAnode deal(String name,DFAnode now){
        DFAnode next = new DFAnode();
        for (node current : now.data){
            for (edge nowEdge = current.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge)
                if (nowEdge.name.equals(name))
                    next.add(nowEdge.tail);
        }
        next.floodfill();
        return next;
    }

    public void tag(){
        ArrayList<node> queue = new ArrayList<>();
        int queueHead = 0;
        queue.add(startState);
        while (queueHead < queue.size()) {
            node now = queue.get(queueHead);
            now.name = queueHead++;
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge){
                if (!nowEdge.tail.getVisit()){
                    queue.add(nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        startState.cleanVisit();
    }

    public void convert(){
        prototype.startState.register(nameOfEdge);
        prototype.startState.cleanVisit();

        DFAnode first = new DFAnode();
        first.add(prototype.startState);
        first.floodfill();
        startState = first;

        LinkedList<DFAnode> queue = new LinkedList<>();
        queue.add(startState);
        int count = 0;

        while (queue.size() > 0){
            DFAnode now = queue.removeFirst();
            now.setName(count++);
            if (!DFAnodeList.contains(now))
                DFAnodeList.add(now);
            if (now.contains(prototype.AcceptState))
                Acceptstate.add(now);

            for (String name : nameOfEdge){
                DFAnode next = deal(name,now);
                if (!DFAnodeList.contains(next)){
                    DFAnodeList.add(next);
                    queue.add(next);
                } else {
                    next = DFAnodeList.get(DFAnodeList.indexOf(next));
                }
                new edge(now,next,name);
            }
        }
        tag();
    }

}
