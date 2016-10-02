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
        nextEdge = head.firstEdge;
        head.firstEdge = this;
    }

}
