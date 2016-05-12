package Ch2;

/**
 * Created by larryliu on 5/11/16.
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * Definition:
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node
 */
public class Ch2Prob8 {
    public Node getLoopStart(Node node) {
        Node itr1 = node.next;
        if (node.next == null) return null;
        Node itr2 = node.next.next;
        while (itr1 != itr2){
            if (itr1 == null || itr2 == null || itr2.next == null) return null;
            itr1 = itr1.next;
            itr2 = itr2.next.next;
        }
        // distance between itr1 and head is the length of the circle
        itr2 = node;
        while (itr1 != itr2) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        return itr1;
    }
}
