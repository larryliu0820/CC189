package Ch4;

import java.util.HashMap;

/**
 * Created by larryliu on 6/19/16.
 * Paths With Sum: You are given a binary tree in which each node contains an integer value (which might be
 * positive or negative). Design an algorithm to count the number of paths that sum to a given value. The
 * path does not need to start or end at the root or leaf, but it must go downwards (traveling only from
 * parent nodes to child nodes).
 */
public class Ch4Prob12 {
    int countPathsWithSum(Node root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathsWithSum(Node node, int targetSum, int runningSum,
                      HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; //base case
        /* Count paths with sum ending at the current node. */
        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /* If runningSum equals targetSum, then one additional path starts at root.
            Add in this path.
         */
        if (runningSum == targetSum) {
            totalPaths++;
        }

        /* Increment pathCount, recurse, then decrement pathCount. */
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
