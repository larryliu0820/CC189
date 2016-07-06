package Ch5;

/**
 * Created by Valued Customer on 6/20/2016.
 * Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
 */
public class Ch5Prob2 {
    String binaryToString(double d) {
        if (d >= 1 || d <= 0)
            return "ERROR";
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (d > 0) {
            if (binary.length() >= 32)
                return "ERROR";

            double r = d * 2;
            if (r >= 1) {
                binary.append(1);
                d = r - 1;
            } else {
                binary.append(0);
                d = r;
            }
        }
        return binary.toString();
    }
}
