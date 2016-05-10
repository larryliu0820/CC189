import java.util.Hashtable;

/**
 * Created by larryliu on 4/30/16.
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Ch1Prob2 {
    public boolean isPermutation(String a, String b) {
        Hashtable<Character, Integer> charTable = new Hashtable<>();
        for (int i = 0; i < a.length(); i++) {
            char it = a.charAt(i);
            if (charTable.containsKey(it)) {
                charTable.put(it, charTable.get(it)+1);
            } else {
                charTable.put(it, 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char it = b.charAt(i);
            if (charTable.containsKey(it)) {
                charTable.put(it, charTable.get(it)-1);
                if (charTable.get(it) == 0) {charTable.remove(it);}
            } else {
                return false;
            }
        }
        if (charTable.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPermutationUsingArray(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] charArray = new int[128];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            charArray[a.charAt(i)] ++;
        }
        for (int i = 0; i < b.length(); i++) {
            charArray[b.charAt(i)] --;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 0) return false;
        }
        return true;
    }
}
