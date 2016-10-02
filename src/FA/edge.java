package FA;

/**
 * Created by Bill on 2016/10/2.
 */
public class edge {
    String name;
    node head,tail;
    edge nextEdge;

    public edge(node _head,node _tail,String _name){
        name = _name;
        head = _head;
        tail = _tail;

        if (head.firstEdge == null)
            head.firstEdge = this;
        if (head.lastEdge != null)
            head.lastEdge.nextEdge = this;
        head.lastEdge = this;
    }

    void delete(){
        if (head.firstEdge == this)
            head.firstEdge = nextEdge;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof edge)
            return head.equals(((edge) obj).head) &&
                    tail.equals(((edge) obj).tail) &&
                    name.equals(((edge) obj).name);
        return false;
    }
}
