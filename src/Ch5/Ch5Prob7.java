package Ch5;

/**
 * Created by Valued Customer on 6/21/2016.
 * Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit
 * 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class Ch5Prob7 {
    int pairwiseSwap(int A) {
        int oddMask = 1;
        for (int i = 0; i < 16; i ++) {
            oddMask = oddMask << 2 + 1;
        }
        int evenMask = oddMask << 1;
        return ((A & oddMask) >>> 1) | ((A & evenMask) << 1);
    }
}
