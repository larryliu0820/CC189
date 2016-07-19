package Ch8;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Valued Customer on 2016/7/18.
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which
 * can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each
 * disk sits on top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a probgram to move the disks from the first tower to the last using stacks.
 */
public class Ch8Prob6 {
    void hanoi(int begin, int end, int mid, int disk, Stack<Integer>[] towers) {
        if (disk <= 0) return;
        // trying to move disk from begin to end.
        // let's assume disk-1 is moved to middle pole.
        hanoi(begin, mid, end, disk-1, towers);
        // move disk from begin to the end.
        if (towers[begin].peek() == disk) {
            int d = towers[begin].pop();
            towers[end].push(d);
        } else {
            return;
        }
        // move disk-1 to the last pole
        hanoi(mid, end, begin, disk-1, towers);
    }
}
