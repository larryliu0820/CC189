import Ch1.Ch1Prob7;
import Ch1.Ch1Prob8;

/**
 * Created by larryliu on 5/3/16.
 */
public class Main {
    public static void main(String[] args) {
/*        Ch1.Ch1Prob2 prob2 = new Ch1.Ch1Prob2();
        String a = "adopiua&*&^*()*^H";
        String b = "Hdopiua&*&^*()*^a";
        boolean result = prob2.isPermutation(a, b);
        System.out.println(result);
        boolean result2 = prob2.isPermutationUsingArray(a, b);
        System.out.println(result2);

        Ch1.Ch1Prob3 prob = new Ch1.Ch1Prob3();
        String src = "Mr Jo hn Smi th        ";
        char[] srcArray = src.toCharArray();
        prob.URLify(srcArray, 15);
        System.out.println(srcArray);

        Ch1.Ch1Prob4 prob4 = new Ch1.Ch1Prob4();
        boolean result4 = prob4.isPalindromePermutation("tact coa");
        System.out.println(result4);

        Ch1.Ch1Prob5 prob5 = new Ch1.Ch1Prob5();
        boolean result5 = prob5.isOneEditAway2("pale", "bake");
        System.out.println(result5);

        Ch1.Ch1Prob6 prob6 = new Ch1.Ch1Prob6();
        String out = prob6.compressString("aabcccccaaa");
        System.out.println(out); */

        int[][] image = new int[4][4];
        int val = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                image[i][j] = val++;
                System.out.print(image[i][j] + " ");
            }
            System.out.print("\n");
        }

        Ch1Prob7 prob7 = new Ch1Prob7();
        prob7.rotate(image);
        printMatrix(image);

        Ch1Prob8 prob8 = new Ch1Prob8();
        image[1][1] = 0;
        image[2][2] = 0;
        prob8.zeroMatrix(image);
        printMatrix(image);
    }

    public static void printMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(mat[i][j] + " ");
            System.out.print("\n");
        }
    }
}
