package Ch2;

import java.util.Hashtable;

/**
 * Created by larryliu on 5/9/16.
 *  Write code to remove duplicates from an unsorted linked list.
 *  Follow up: how would you solve this problem if a temporary buffer is not allowed?
 */
public class Ch2Prob1 {

    public void removeDuplicates(LinkedList list) {
        Hashtable<Integer,Boolean> table = new Hashtable<>();
        Node n = list.head;
        while (n != null) {
            if (table.containsKey(n.data)) {
                list.removeNode(n);
            } else {
                table.put(n.data, true);
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
