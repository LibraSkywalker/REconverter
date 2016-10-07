package Kernel.FA;

/**
 * Created by Bill on 2016/10/2.
 */
public class Edge {
    String name;
    Node head,tail;
    Edge nextEdge;

    public Edge(Node _head, Node _tail, String _name){
        name = _name;
        head = _head;
        tail = _tail;
        head.edges.add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge)
            return head.equals(((Edge) obj).head) &&
                    tail.equals(((Edge) obj).tail) &&
                    name.equals(((Edge) obj).name);
        return false;
    }
}
