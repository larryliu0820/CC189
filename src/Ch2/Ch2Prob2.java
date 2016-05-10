package Ch2;

/**
 * Created by larryliu on 5/9/16.
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Ch2Prob2 {
    public Node findLastKthElement(LinkedList list, int k) {
        if (k < 1) return null;
        Node n1 = list.head;
        Node n2 = n1;
        for (int i = 0; i < k - 1; i++) {
            if (n2 == null) return null;
            n2 = n2.next;
        }
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
