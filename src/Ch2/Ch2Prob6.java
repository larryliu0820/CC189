package Ch2;

/**
 * Created by mengwliu on 5/11/16.
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Ch2Prob6 {
    public boolean isPalindrome(Node node) {
        if(node.next == null) return true;
        Node result = isPalindromeHelper(node, node.next);
        return result != null;
    }

    public Node isPalindromeHelper(Node head, Node tail) {
        if (tail.next == null) {
            if (head.data == tail.data) return head.next;
            else return null;
        }
        Node nowHead = isPalindromeHelper(head, tail.next);
        if (nowHead == null || nowHead.data != tail.data) return null;
        else return nowHead.next;
    }
}
