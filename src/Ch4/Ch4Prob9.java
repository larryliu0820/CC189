package Ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Valued Customer on 6/8/2016.
 * BST Sequences: A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 */
public class Ch4Prob9 {
    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                   ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* one list is empty. Add remainder to [a cloned] prefix and store the result. */
        if (first.size() == 0 || second.size() == 0) {
           LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
           result.addAll(first);
           result.addAll(second);
           results.add(result);
           return;
        }

        /* Resurse with head of first added to the prefix. Removing the head will damage first, so we'll need to put
        it back where we found it afterwards.
        */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    ArrayList<LinkedList<Integer>> allSequences(Node node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.value);

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left: leftSeq) {
            for (LinkedList<Integer> right: rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }
}
