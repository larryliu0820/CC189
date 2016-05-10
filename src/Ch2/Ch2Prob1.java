package Ch2;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by larryliu on 5/9/16.
 *  Write code to remove duplicates from an unsorted linked list.
 *  Follow up: how would you solve this problem if a temporary buffer is not allowed?
 */
public class Ch2Prob1 {

    public void removeDuplicates(LinkedList list) {
        HashSet<Integer> table = new HashSet<>();
        Node n = list.head;
        while (n != null) {
            if (table.contains(n.data)) {
                list.removeNode(n);
            } else {
                table.add(n.data);
            }
            n = n.next;
        }
    }

    public void removeDuplicatesNoBuffer(LinkedList list) {
        Node n1 = list.head;
        while (n1 != null) {
            Node n2 = n1;
            while (n2.next != null) {
                if (n1.data == n2.next.data) {
                    // delete n2.next
                    n2.next = n2.next.next;
                } else {
                    n2 = n2.next;
                }
            }
            n1 = n1.next;
        }
    }
}
