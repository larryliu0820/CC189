import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by larryliu on 5/8/16.
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Ch1Prob7 {
    public void rotate(int[][] image) {
        /*
        1 2 3 4
        5 6 7 8
        9 0 1 2
        2 4 5 7

        1 2 3
        4 5 6
        7 8 9
         */
        int length = image.length;
        for (int layer = 0; layer < length / 2; layer ++) {
            // rotate elements in this layer
            for (int col = layer; col < length - 1 - layer; col++) {
                rotateFourElements(image, layer, col);
            }
        }
    }

    public void rotateFourElements(int[][] image, int row, int col) {
        int temp = image[row][col];
        int len = image.length-1;
        image[row][col] = image[len-col][row];
        image[len-col][row] = image[len-row][len-col];
        image[len-row][len-col] = image[col][len-row];
        image[col][len-row] = temp;
    }
}
