/**
 * Created by larryliu on 5/8/16.
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string,
 * your method should return the original string. (A-Za-z)
 */
public class Ch1Prob6 {
    public String compressString(String original) {
        StringBuilder builder = new StringBuilder();
        char current = original.charAt(0);
        int count = 1;
        for (int itr = 0; itr < original.length(); itr++) {
            if (original.charAt(itr) != current) {
                builder.append(current);
                builder.append(count);
                current = original.charAt(itr);
                count = 1;
            } else {
                count ++;
            }
        }
        builder.append(current);
        builder.append(count);
        String output = builder.toString();
        if(output.length() > original.length()) return original;
        else return output;
    }
}
