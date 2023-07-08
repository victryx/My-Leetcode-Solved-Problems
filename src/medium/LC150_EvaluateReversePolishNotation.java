package medium;

import java.util.Stack;

public class LC150_EvaluateReversePolishNotation {

    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * Evaluate Reverse Polish Notation<br />
     * Solved with help <br />
     * Solved: 2023-07-08
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (canParse(token)) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            }
        }

        return stack.pop();
    }

    private boolean canParse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
