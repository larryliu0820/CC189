package Ch4;

/**
 * Created by Valued Customer on 6/3/2016.
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree
 * such that the height of the two subtrees of any node never differ by more than 1.
 */
public class Ch4Prob4 {
    public boolean isBalanced(Node root) {
        int height = getHeight(root);
        return height != Integer.MIN_VALUE;
    }

    public int getHeight(Node root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = getHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
