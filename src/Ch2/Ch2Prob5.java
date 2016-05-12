package Ch2;

/**
 * Created by larryliu on 5/11/16.
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's
 * digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) That is 617 + 295.
 * Output: 2 -> 1 -> 9. That is 912.
 *
 * Follow up
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class Ch2Prob5 {
    public Node sumLists(Node a, Node b) {
        Node itrA = a;
        Node itrB = b;
        Node c = new Node(0);
        Node itrC = c;
        int sum = 0;
        int carry = 0;
        while (itrA != null || itrB != null || carry != 0) {
            sum = (itrA == null ? 0 : itrA.data) + (itrB == null ? 0 : itrB.data) + carry;
            carry = sum / 10;
            itrC.next = new Node(0);
            itrC = itrC.next;
            itrC.data = sum % 10;
            if (itrA != null) itrA = itrA.next;
            if (itrB != null) itrB = itrB.next;
        }

        return c.next;
    }

    public Node sumListsForward(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        // align two lists
        Node itrHead1 = alignLists(a, b);
        Node itrHead2 = null;
        Node itr = itrHead1;
        while(itr != null) {
            if (itr == a) {itrHead2 = b; break;}
            if (itr == b) {itrHead2 = a; break;}
            itr = itr.next;
        }
        Node c = new Node(0);
        int carry = sumListsHelper(itrHead1, itrHead2, c);
        if (carry > 0) {
            Node head = new Node(carry);
            head.next = c;
            return head;
        }
        return c;
    }

    private Node alignLists(Node a, Node b) {
        Node itrA = a;
        Node itrB = b;
        while (itrA != null && itrB != null) {
            itrA = itrA.next;
            itrB = itrB.next;
        }
        boolean isALonger = (itrB == null);
        Node c = new Node(0);
        Node h = c;
        Node itrTail = isALonger?itrA:itrB;
        while (itrTail != null) {
            itrTail = itrTail.next;
            c.next = new Node(0);
            c = c.next;
        }
        c.next = isALonger?b:a;
        Node itrHead = h.next;
        return itrHead;
    }
    private int sumListsHelper(Node a, Node b, Node c) {
        //base case
        if (a.next == null && b.next == null) {
            int sum = a.data + b.data;
            c.data = sum % 10;
            return sum / 10;
        }
        Node itrA = (a.next == null ? a:a.next);
        Node itrB = (b.next == null ? b:b.next);
        c.next = new Node(0);
        int carry = sumListsHelper(itrA, itrB, c.next);
        int sum = a.data + b.data + carry;
        c.data = sum % 10;
        return sum / 10;
    }
}
