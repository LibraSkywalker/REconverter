package Kernel.FA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Bill on 2016/10/2.
 */
public class Node {
    String name;
    boolean visit = false;
    LinkedList<Edge> edges = new LinkedList<>();

    public void setVisit(){
        visit = true;
    }
    public boolean getVisit(){
        return visit;
    }

    public Node(String _name){
        name = _name;
    }

    public Node(){}
    public void cleanVisit(){
        visit = false;
        for (Edge now : edges){
            if (now.tail.getVisit())
                now.tail.cleanVisit();
        }
    }
    public void register(Set<String> list){
        visit = true;
        for (Edge now : edges)
            if (!now.tail.visit) {
                if (!list.contains(now.name) && !now.name.equals(" "))
                    list.add(now.name);
                now.tail.setVisit();
                now.tail.register(list);
            }
    }

    @Override
    public String toString() {
        return (name != null) ? name : "UNamed";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node)
            return name.equals(((Node) obj).name);
        return false;
    }
}
