/**
 * Created by larryliu on 5/8/16.
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class Ch1Prob8 {
    public void zeroMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        boolean[] isRowZero = new boolean[height];
        boolean[] isColZero = new boolean[width];

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    isColZero[i] = true;
                    isRowZero[j] = true;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isColZero[i] || isRowZero[j]) mat[i][j] = 0;
            }
        }
    }
}
