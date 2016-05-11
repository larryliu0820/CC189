package Ch2;

/**
 * Created by larryliu on 5/9/16.
 */
public class LinkedList {
    public Node head = null;
    public Node tail = null;
    public int N = 0;

    public LinkedList(){}

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
            N--;
            return;
        }
        while (itr.next != null) {
            if (itr.next == n) {
                if (n == tail) tail = itr;
                itr.next = itr.next.next;
                N--;
                return;
            }
            itr = itr.next;
        }
    }

    public void insertHead(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
        if (N == 0) tail = n;
        N++;
    }

    public void insertTail(int d) {
        Node itr = tail;
        if (N == 0) {
            insertHead(d);
        } else {
            itr.next = new Node(d);
            tail = itr.next;
            N++;
        }
    }
    public void printList() {
        Node itr = head;
        if (itr == null) {
            System.out.println("head is null.");
        }
        while(itr != null) {
            System.out.print(itr.data + "->");
            itr = itr.next;
        }
        System.out.print("null\n");
    }

    public Node getNthNode(int n) {
        if (n > N || n < 1) return null;
        Node itr = head;
        for (int i = 0; i < n-1; i++) itr = itr.next;
        return itr;
    }
}
