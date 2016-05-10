/**
 * Created by larryliu on 5/8/16.
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class Ch1Prob9 {
    public boolean isRotation(String str1, String str2) {
        // concat two str1s and check if str2 is a sub string of it
        String testStr = str1 + str1;
        return testStr.contains(str2);
    }
}
