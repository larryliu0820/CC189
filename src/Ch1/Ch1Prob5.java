package Ch1;

import static java.lang.Math.abs;

/**
 * Created by larryliu on 5/4/16.
 * There are three types of edits that can be performed on strings: insert a character, remove a character or replace a character. Given two strings,
 * write a function to check if they are one edit(or zero edits) away.
 * Example:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class Ch1Prob5 {
    public boolean isOneEditAway(String a, String b) {
        int diff = abs(a.length() - b.length());
        if (diff > 2) return false;
        int aBackwardPtr = a.length() - 1;
        int bBackwardPtr = b.length() - 1;
        int smallerLength = a.length() > b.length() ? b.length():a.length();
        int forwardPtr = 0;
        for (; forwardPtr < smallerLength - 1; forwardPtr ++) {
            if (a.charAt(forwardPtr) != b.charAt(forwardPtr))
                break;
        }
        System.out.println("forwardPtr = " + forwardPtr);
        while (forwardPtr != aBackwardPtr && forwardPtr != bBackwardPtr) {
            System.out.println("aBackwardPtr = " + aBackwardPtr);
            System.out.println("bBackwardPtr = " + bBackwardPtr);
            if (a.charAt(aBackwardPtr) != b.charAt(bBackwardPtr))
                return false;
            aBackwardPtr--;
            bBackwardPtr--;
        }
        return true;
    }

    public boolean isOneEditAway2(String first, String second) {
        if (abs(first.length() - second.length()) > 1) return false;
        String str1 = first.length() > second.length()?second:first;
        String str2 = first.length() > second.length()?first:second;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if(foundDifference) return false;
                foundDifference = true;
                if(str1.length() < str2.length()) index2++;
            }
            index1++;
            index2++;
        }
        return true;
    }
}
