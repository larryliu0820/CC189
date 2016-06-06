package Ch4;

/**
 * Created by larryliu on 5/25/16.
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */
public class Ch4Prob2 {
    Node createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length-1);
    }

    Node createMinimalBST(int array[], int begin, int end) {
        if (end < begin) {
            return null;
        }
        int mid = (begin + end) / 2;
        Node n = new Node(array[mid]);
        n.left = createMinimalBST(array, begin, mid-1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }
}
