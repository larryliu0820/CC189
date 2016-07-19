package Ch8;

/**
 * Created by Valued Customer on 2016/7/13.
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator. You can
 * use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
public class Ch8Prob5 {
    int recursiveMultiply(int op1, int op2) {
        int bigger = op1 > op2 ? op1: op2;
        int smaller = op1 > op2 ? op2: op1;

        int[] memo = new int[smaller];
        return helper(smaller, bigger, memo);
    }

    int helper(int smaller, int bigger, int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }

        int half = smaller >> 1;

        int side1 = helper(half, bigger, memo);
        memo[half] = side1;
        int side2;
        if (smaller % 2 == 0) {
            side2 = side1;
        } else {
            side2 = helper(smaller - half, bigger, memo);
            memo[smaller-half] = side2;
        }
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
}
