package Ch2;

/**
 * Created by mengwliu on 5/11/16.
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
 * intersection is based on reference, not value. That is, if the kth of node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
public class Ch2Prob7 {
    public Node isIntersecting(Node a, Node b) {
        Node itrA = a;
        Node itrB = b;
        while(itrA != null && itrB != null) {
            itrA = itrA.next;
            itrB = itrB.next;
        }
        boolean isALonger = (itrA != null);
        Node head1 = isALonger?a:b;
        Node head2 = isALonger?b:a;
        Node tail1 = isALonger?itrA:itrB;
        while(tail1 != null) {
            tail1 = tail1.next;
            head1 = head1.next;
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) return head2;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
