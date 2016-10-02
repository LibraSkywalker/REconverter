package FA;

import java.util.Set;

/**
 * Created by Bill on 2016/10/2.
 */
public class node {
    Integer name;
    boolean visit = false;
    edge firstEdge,lastEdge;
    public void setVisit(){
        visit = true;
    }
    public boolean getVisit(){
        return visit;
    }

    public void cleanVisit(){
        visit = false;
        for (edge now = firstEdge; now != null ; now = now.nextEdge)
            if (now.tail.visit) {
                now.tail.visit = false;
                now.tail.cleanVisit();
            }
    }
    public void register(Set<String> list){
        visit = true;
        for (edge now = firstEdge; now != null ; now = now.nextEdge)
            if (!now.tail.visit) {
                if (!list.contains(now.name) && !now.name.equals(" "))
                    list.add(now.name);
                now.tail.setVisit();
                now.tail.register(list);
            }
    }
    @Override
    public String toString() {
        return (name != null) ? name.toString() : "UNamed";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof node)
            return name.equals(((node) obj).name);
        return false;
    }
}
