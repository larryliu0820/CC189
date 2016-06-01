package Ch3;

import java.util.Stack;

/**
 * Created by larryliu on 5/17/16.
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek and isEmpty.
 */
public class Ch3Prob5 {

    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (s.size() != 0) {
            int top = s.pop();
            while (r.size() != 0 && r.peek() < top) {
                s.push(r.pop());
            }
            r.push(top);
        }

        while (r.size() != 0) {
            s.push(r.pop());
        }
    }
}
