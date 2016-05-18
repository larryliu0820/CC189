package Ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by larryliu on 5/13/16.
 * Imagine a (literal) stack of plates. if the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when
 * the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetofStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
 * stack (that is, pop() should return the same values as it would if there were just a single stack).
 *
 * Follow up:
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class Ch3Prob3 {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int capacity;
    void push(int v) {
        Stack last = stacks.get(stacks.size()-1);
        if (last != null && last.size() < capacity ) {
            last.push(v);
        } else {
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        }
    }
    int pop() {
        Stack<Integer> last = stacks.get(stacks.size()-1);
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size() == 0) stacks.remove(stacks.size() - 1);
        return v;
    }
    public Ch3Prob3(int capacity) {

    }
}
