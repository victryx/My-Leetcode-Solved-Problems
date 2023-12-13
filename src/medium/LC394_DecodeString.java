package medium;

import java.util.Stack;

public class LC394_DecodeString {

    /**
     * <b>1st Try.</b> <br />
     * Recursive solution<br />
     * TODO Refactor this ugly messy code
     * Solved: 2023-12-13
     */
    public static String decodeString(String s, int times) {

        StringBuilder result = new StringBuilder();
        int open, close;

        for (int i = 0; i < s.length(); i++) {
            int n = 0;
            Stack<Integer> st = new Stack<>();
            while (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                st.push(num);
                i++;
            }
            int mult = 1;
            while (!st.isEmpty()) {
                n += st.pop() * mult;
                mult *= 10;
            }

            if (n == 0) result.append(s.charAt(i));

            else if (s.charAt(i) == '[') {
                int balance = 1;
                i++;
                open = i;
                while (balance != 0) {
                    if (s.charAt(i) == '[') balance++;
                    if (s.charAt(i) == ']') balance--;
                    i++;
                }
                close = --i;

                result.append(decodeString(s.substring(open, close), n));
            }
        }

        String repeated = result.toString();
        while (times > 1) {
            result.append(repeated);
            times--;
        }

        return result.toString();
    }

    public static String decodeString(String s) {
        return decodeString(s, 1);
    }
}
