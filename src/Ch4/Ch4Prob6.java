package Ch4;

/**
 * Created by larryliu on 6/5/16.
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary
 * search tree. You man assume that each node has a link to its parent.
 */
public class Ch4Prob6 {
    public Node getNextNode(Node n) {
        if (n == null) return null;
        if (n.right != null) {
            return leftMostChild(n.right);
        }
        Node child = n;
        Node parent = n.parent;
        while (parent != null && parent.left != child) {
            child = parent;
            parent = parent.parent;
        }
        return parent;
    }
    public Node leftMostChild(Node n) {
        if (n == null) return null;
        while (n.left != null) n = n.left;
        return n;
    }
}
