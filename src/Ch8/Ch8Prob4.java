package Ch8;

import java.util.ArrayList;

/**
 * Created by Valued Customer on 2016/7/12.
 * Power Set: Write a method to return all subsets of a set.
 */
public class Ch8Prob4 {
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (index == 0) {
            ArrayList<Integer> empty = new ArrayList<>();
            allSubsets = new ArrayList<>();
            allSubsets.add(empty);
            return allSubsets;
        }
        allSubsets = getSubsets(set, index - 1);
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
        for (ArrayList<Integer> subset : allSubsets) {
            ArrayList<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(set.get(index-1));
            moreSubsets.add(newSubset);
        }
        allSubsets.addAll(moreSubsets);
        return allSubsets;
    }
}
