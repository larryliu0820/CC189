package Ch5;

/**
 * Created by Valued Customer on 6/21/2016.
 * Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to 1. Write code to find the length of
 * the longest sequence of 1s you could create.
 * EXAMPLE
 * Input: 1775 (11011101111)
 * Output: 8
 */
public class Ch5Prob3 {
    int longestSequence(int i) {
        int previousLength = 0;
        int currentLength = 0;
        int maxLength = 1;

        while (i > 0) {
            boolean currentBitIsOne = i % 2 == 1;
            i = i >>> 1;
            if (currentBitIsOne) {
                currentLength++;
            } else {
                if ( i % 2 == 1) { // next bit is 1
                    previousLength = currentLength;
                } else { // next bit is 0
                    previousLength = 0;
                }
                currentLength = 0;
                maxLength = Integer.max(maxLength, currentLength + previousLength + 1);
            }
        }
        return maxLength;
    }
}
