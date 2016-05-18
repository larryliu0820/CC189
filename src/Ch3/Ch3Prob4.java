package Ch3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by larryliu on 5/17/16.
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Ch3Prob4 {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public Ch3Prob4() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(int v) {
        inStack.push(v);
    }

    public int dequeue() {
        if (outStack.size() > 0) {
            return outStack.pop();
        } else {
            moveStack();
            if (outStack.size() == 0) throw new EmptyStackException();
            else return outStack.pop();
        }
    }

    private void moveStack() {
        while (inStack.size() != 0) {
            outStack.push(inStack.pop());
        }
    }
}
