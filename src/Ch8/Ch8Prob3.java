package Ch8;

/**
 * Created by Valued Customer on 2016/7/8.
 * Magic Index: A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. Given a sorted array
 * of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
public class Ch8Prob3 {
    int magicFast(int[] array) {
        return magicFast(array, 0, array.length-1);
    }

    int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    int magicFast2(int[] array, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        // Search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) return left;

        // Search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, start, rightIndex);

        return right;
    }
}
