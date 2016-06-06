package Ch4;



import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Valued Customer on 6/1/2016.
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree
 * with depth D, you'll have D linked lists).
 */
public class Ch4Prob3 {
    public ArrayList<LinkedList> listOfDepths(Node root) {
        ArrayList<LinkedList> array = new ArrayList<>();
        if (root == null) return array;
        LinkedList<Node> list;
        list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()) {
            array.add(list);
            LinkedList<Node> childList = new LinkedList<>();
            for (Node node : list) {
                if (node.left != null) childList.add(node.left);
                if (node.right != null) childList.add(node.right);
            }
            list = childList;
        }
        return array;
    }
}
