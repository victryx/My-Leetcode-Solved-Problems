package medium;

import java.util.Stack;

public class LC155_MinStack {


    public static void main(String[] args) {
        MinStack mStack = new MinStack();
        mStack.push(-2);
        mStack.push(0);
        mStack.push(-3);
        System.out.println(mStack.getMin());
        mStack.pop();
        System.out.println(mStack.top());
        System.out.println(mStack.getMin());
    }

    static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() { }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
