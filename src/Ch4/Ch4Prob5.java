package Ch4;

/**
 * Created by larryliu on 6/5/16.
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class Ch4Prob5 {
    Integer lastPrinted = null;
    public boolean checkBST(Node root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return false;

        if (lastPrinted != null && root.val <= lastPrinted) return false;

        lastPrinted = root.val;

        if (!checkBST(root.right)) return false;

        return true;
    }
    public boolean isBST(Node root) {
        int minVal = Integer.MIN_VALUE;
        int maxVal = Integer.MAX_VALUE;
        return isBSTHelper(root, minVal, maxVal);
    }

    public boolean isBSTHelper(Node root, int min, int max) {
        if (root == null ) return true;
        if (root.val > max || root.val <= min) return false;
        if (!isBSTHelper(root.left, min, root.val) || !isBSTHelper(root.right, root.val, max)) return false;
        return true;
    }
}
