package Kernel.FA;

import java.util.*;

/**
 * Created by Bill on 2016/10/2.
 */
public class DFA extends NFA{
    Node startState;
    ArrayList<Node> Acceptstate = new ArrayList<>();
    Set<String> nameOfEdge = new HashSet<>();
    Map<Set<Node>,Node> transTable = new HashMap<Set<Node>,Node>();
    public DFA(){
    }

    String AcceptState(){
        String str = "";
            for (Node now : Acceptstate)
                str += "," + now.toString() ;
        return  str.substring(1);
    }

    @Override
    public String toString() {
        String str = "digraph{\n" +
                "\trankdir = LR\n" +
                "\tNode[shape = circle]\n" +
                "\tstart[style = invis]\n" +
                "\tstart->"+ startState +"[label = start]\n" +
                "\t"+ AcceptState() +"[shape = doublecircle]\n";

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

        startState.cleanVisit();
        return str + "}";
    }

    public String list(){
        String str = "\\begin{table}[!hbp]\n" +
                "\\begin{tabular}{";
        for (int i = 0; i < nameOfEdge.size(); i++)
            str += "|c";

        str += "|c|c|}\n";
        str += "\\hline\n";
        str += "NFA\t\t& DFA\t";
        for (String name : nameOfEdge)
            str += "& "+ name + "\t";
        str += "\\\\\n";
        str += "\\hline\n";

        for (Map.Entry now : transTable.entrySet()){
            str += now.getKey() + "\t" + "&" + now.getValue() + "\t";
            Node nowNode =(Node) now.getValue();
            for (Edge nowEdge : nowNode.edges){
                str += "& " + nowEdge.tail + "\t";
            }
            str += "\\\\\n";
            str += "\\hline\n";
        }

        str += "\\end{tabular}\n" +
                "\\end{table} \n";
        startState.cleanVisit();
        return str;
    }

    void put(Set<Node> key,Node value){
        if (key.contains()
    }

}
