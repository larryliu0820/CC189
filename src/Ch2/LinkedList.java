package Ch2;

/**
 * Created by larryliu on 5/9/16.
 */
public class LinkedList {
    public Node head = null;

    public LinkedList(Node n) {
        head = n;
    }

    public LinkedList(int d) {
        head = new Node(d);
        head.next = null;
    }

    public void removeNode(Node n) {
        Node itr = head;
        if (head == null) return;
        if (head == n) {
            head = head.next;
            return;
        }
        while (itr.next != null) {
            if (itr.next == n) {
                itr.next = itr.next.next;
                return;
            }
            itr = itr.next;
        }
    }

    public void insertHead(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public void insertTail(int d) {
        Node itr = head;
        if (itr == null) {
            insertHead(d);
        } else {
            while (itr.next != null) itr = itr.next;
            itr.next = new Node(d);
            itr.next.next = null;
        }
    }
    public void printList() {
        Node itr = head;
        if (itr == null) {
            System.out.println("head is null.");
        }
        while(itr.next != null) {
            System.out.print(itr.data + "->");
        }
        System.out.print("null");
    }
}
