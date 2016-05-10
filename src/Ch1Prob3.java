/**
 * Created by larryliu on 5/2/16.
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. Java: character array, in place
 */
public class Ch1Prob3 {
    public void URLify(char[] src, int len) {
        // Start from the end
        int t = src.length - 1;
        int s = len - 1;
        for (; s >= 0; s--) {
            if (src[s] != ' ') {
                src[t--] = src[s];
            } else {
                src[t--] = '0';
                src[t--] = '2';
                src[t--] = '%';
            }
        }
    }

}


