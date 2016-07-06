package Ch5;

/**
 * Created by Valued Customer on 6/21/2016.
 * Conversion: Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 */
public class Ch5Prob6 {
    int convert(int A, int B) {
        int xored = A ^ B;
        int numOfOne = 0;
        while (xored != 0) {
            xored = xored & (xored - 1);
            numOfOne++;
        }
        return numOfOne;
    }
}
