package Ch4;

/**
 * Created by Valued Customer on 6/6/2016.
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class Ch4Prob8 {
    class Result {
        public Node node;
        public boolean isAncestor;
        public Result(Node n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }
    public Node findCommonAncestor(Node root, Node n1, Node n2) {

        Result r = commonAncestorHelper(root, n1, n2);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    public Result commonAncestorHelper(Node root, Node p, Node q) {
        if (root == null) return new Result(null, false);
        if (root == p && root == q) return new Result(root, true);
        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) return rx;

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) return ry;

        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }
}
