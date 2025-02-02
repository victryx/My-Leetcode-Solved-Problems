package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LC22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new LC22_GenerateParentheses().generateParenthesis3(3).toString());
    }

    /**
     * <b>1st Try.</b> <br />
     * Brute force approach<br />
     * Solved: 2023-07-08
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generateParenthesesHelper(ls, n * 2, "(");
        return ls;
    }
    public static void generateParenthesesHelper(List<String> ls, int n, String cur) {
        if (cur.length() == n) {
            if (isValid(cur))
                ls.add(cur);
            return;
        }

        generateParenthesesHelper(ls, n, cur + ")");
        generateParenthesesHelper(ls, n, cur + "(");
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    /**
     * <b>Solved with help</b> <br />
     * Solved: 2023-07-08
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ls = new ArrayList<>();
        generateParenthesesHelper(ls, n, "(");
        return ls;
    }

    public void generateParenthesesHelper(List<String> ls, String cur, int n, int open, int close) {
        if (close == n && open == n) {
            ls.add(cur);
            return;
        }

        if (close < open) {
            generateParenthesesHelper(ls, cur + ")", n, open, close + 1);
        }

        if (open < n) {
            generateParenthesesHelper(ls, cur + "(", n, open + 1, close);
        }
    }

    /**
     * Iterative Backtracking
     */
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis3(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
