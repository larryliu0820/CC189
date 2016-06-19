package Ch4;

/**
 * Created by larryliu on 6/11/16.
 * Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm
 * to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Ch4Prob10 {
    public boolean checkSubtree(Node t1, Node t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    public boolean subTree(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        } else if (t1.val == t2.val && matchTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public boolean matchTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
