package Ch2;

/**
 * Created by larryliu on 5/10/16.
 *  Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 *  If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can
 *  appear anywhere in the "right partition"; it doesn't need to appear between the left and right partitions.
 *
 *  EXAMPLE
 *
 *  Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [Partition = 5]
 *  Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Ch2Prob4 {
    public void partition(LinkedList list, int key) {
        Node temp = new Node(0);
        temp.next = list.head;
        Node itr = temp;
        // move itr to the point where itr.next is larger than key
        while (itr.next != null) {
            if (itr.next.data < key) itr = itr.next;
            else break;
        }
        if (itr == null) return;
        Node itr2 = itr.next;
        while (itr2.next != null) {
            if (itr2.next.data >= key) itr2 = itr2.next;
            else {
                // remove target after itr2
                Node target = itr2.next;
                itr2.next = itr2.next.next;
                // insert target after itr
                Node tmp = itr.next;
                itr.next = target;
                target.next = tmp;
                // increment itr
                itr = itr.next;
            }
        }

        list.head = temp.next;
    }
}
