package FA;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Bill on 2016/10/2.
 */
public class DFAnode extends node{
    Set<node> data = new HashSet<>();

    void add(node e){
        if (!data.contains(e))
            data.add(e);
    }

    boolean contains(node e){
        return data.contains(e);
    }

    void floodfill(){
        LinkedList<node> origin = new LinkedList<>();
        for (node now : data){
            origin.add(now);
            now.setVisit();
        }
        while (origin.size() > 0){
            node now = origin.removeFirst();
            now.setVisit();
            for (edge nowEdge = now.firstEdge; nowEdge != null; nowEdge = nowEdge.nextEdge){
                if (nowEdge.name.equals(" ") && !nowEdge.tail.getVisit()) {
                    origin.add(nowEdge.tail);
                    data.add(nowEdge.tail);
                    nowEdge.tail.setVisit();
                }
            }
        }
        for (node now : data)
            now.cleanVisit();
    }

    void setName(int num){
        name = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DFAnode)
            return data.equals(((DFAnode) obj).data);
        return false;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public String origin(){
        String str = "";
        for (node now : data){
            str += "," + now.toString();
        }
        return  (str.equals("") ? "trap" : ("{" + str.substring(1)) + "}");
    }

    DFAnode find(Set<DFAnode> reg){
        for (DFAnode now : reg)
            if (now.equals(this))
                return now;
        return null;
    }
}
