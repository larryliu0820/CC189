package Ch3;

import java.util.Stack;

/**
 * Created by larryliu on 5/12/16.
 *  How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should
 *  all operate in O(1) time.
 */
public class Ch3Prob2 extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}

class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
}

