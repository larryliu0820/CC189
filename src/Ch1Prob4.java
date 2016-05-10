/**
 * Created by larryliu on 5/3/16.
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary
 * words.
 * Example:
 *
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atcocta", etc.)
 */
public class Ch1Prob4 {
    public boolean isPalindromePermutation(String src) {
        int[] charArray = new int[128];
        int len = src.length();
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == ' ') {
                len--;
                continue;
            }
            charArray[src.charAt(i)]++;
        }
        // Search for odd number in charArray.
        int oddCount = 0;
        for (int itr : charArray) {
            if (itr % 2 == 1) oddCount++;
            if (oddCount > 1) return false;
        }
        if (len % 2 == 0 && oddCount == 0) return true;
        if (len % 2 == 1 && oddCount == 1) return true;
        return false;
    }
}
