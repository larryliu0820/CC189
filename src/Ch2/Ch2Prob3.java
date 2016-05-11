package Ch2;

/**
 * Created by larryliu on 5/10/16.
 *  Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly
 *  linked list, given only access to that node.
 */
public class Ch2Prob3 {
    public void deleteNode(Node node) {
        // copy the data from the nodes after node
        if(node.next == null) return;
        Node itr = node;
        while (itr.next.next != null) {
            itr.data = itr.next.data;
            itr = itr.next;
        }
        itr.data =itr.next.data;
        itr.next = null;
    }
}
