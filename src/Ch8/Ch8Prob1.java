package Ch8;

/**
 * Created by Valued Customer on 7/5/2016.
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 step, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class Ch8Prob1 {
    int count(int steps) {
        if (steps == 0) return 0;
        int zeroMem = 0;
        int oneMem = 1;
        int twoMem = 2;
        for (int i = 3; i < steps; i++) {
            int result = zeroMem + oneMem + twoMem;
            zeroMem = oneMem;
            oneMem = twoMem;
            twoMem = result;
        }
        return zeroMem + oneMem + twoMem;
    }

}
