package Ch1;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by larryliu on 4/29/16.
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
public class Ch1Prob1 {
    public boolean isUnique(String input) {

        Hashtable<Character, Integer> charTable = new Hashtable<>();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (charTable.containsKey(temp)) {
                return false;
            } else {
                charTable.put(temp, 1);
            }
        }
        return true;
    }
    public boolean isUniqueUsingArr(String input) {
        int length = 'Z' - 'a';
        boolean[] charArr = new boolean[length];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (charArr[(int)input.charAt(i) - 'a']) {
                return false;
            } else {
                charArr[(int)input.charAt(i) - 'a'] = true;
            }
        }
        return true;
    }
}
