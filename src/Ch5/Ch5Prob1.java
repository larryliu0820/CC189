package Ch5;

/**
 * Created by larryliu on 6/19/16.
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert
 * M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough
 * space to fit all of M. That is, if M=10011, you can assume that there are at least 5 bits between j and i. You
 * would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit2.
 */
public class Ch5Prob1 {
    int insert(int N, int M, int i, int j) {
        int shifted = M << i; // 0001001010010000000
        int maskM = ~(~0 << (j+1));//0000001111111111111
        int shiftedM = shifted & maskM; // 0000001010010000000

        int maskN = ~((~0 << i) & ~(~0 << (j+1))); // 111111000000111111
        int maskedN = N & maskN;

        return maskedN | shiftedM;
    }
}
