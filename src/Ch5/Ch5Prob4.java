package Ch5;

/**
 * Created by Valued Customer on 6/22/2016.
 * Next Number: Given a positive integer, print the next smallest and the next largest number that have the same number
 * of 1 bits in their binary representation.
 */
public class Ch5Prob4 {
    int getNext(int n) {
        /* Compute c0 and c1 */
        // p: the position we flip a 0 to 1, the rightmost non-trailing zero
        // c0: the number of zeros to the right of p
        // c1: the number of ones to the right of p
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        // Error case: if n == 11..11100..000, then there is no bigger number with the same number of 1s.
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1; // position of rightmost non-trailing zero
        n |= (1 << p); // Flip 0 at p to 1
        n &= ~((1 << p) - 1); // Clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // Insert (c1 - 1) ones on the right.
        return n;
    }

    int getPrev(int n) {
        // p: the position we flip a 1 to 0, the rightmost non-trailing one
        // c0: the number of zeros to the right of p
        // c1: the number of ones to the right of p
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1; //position of rightmost non-trailing one
        n &= ((~0) << (p + 1)); // Clear all bits to the right of p
        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);

        return n;
    }
}
