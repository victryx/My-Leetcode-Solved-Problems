package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class LC76_MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Sliding Window Solution<br />
     * Solved: 2023-07-02
     */
    public static String minWindow(String s, String t) {
        int[] requiredChars = new int[128];
        int[] windowChars = new int[128];
        String bestSubstring = "";

        for (int i = 0; i < t.length(); i++) {
            requiredChars[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            while (r < s.length() && !validSubstring(windowChars, requiredChars)) {
                windowChars[s.charAt(r)]++;
                r++;
            }

            while (validSubstring(windowChars, requiredChars)) {
                if (bestSubstring.equals("") || r - l < bestSubstring.length()){
                    bestSubstring = s.substring(l, r);
                }
                windowChars[s.charAt(l)]--;
                l++;

            }
        }

        return bestSubstring;
    }
    
    private static boolean validSubstring(int[] windowChars, int[] requiredChars) {
        for (int i = 0; i < requiredChars.length; i++) {
            if (requiredChars[i] > windowChars[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * <b>2nd Try.</b> <br />
     * Sliding Window Solution<br />
     * Solved: 2023-07-05
     */
    public static String minWindow2(String s, String t) {
        Map<Character, Integer> tChars = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        String currentResult = "";

        for (int i = 0; i < t.length(); i++) {
            tChars.put(t.charAt(i), tChars.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = tChars.size();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0) + 1);

            if (tChars.containsKey(c) && window.get(c).equals(tChars.get(c))) {
                have++;
            }

            while (have == need) {
                // Update result
                if (currentResult.equals("") || currentResult.length() > (right - left + 1)) {
                    currentResult = s.substring(left, right + 1);
                }

                // Update left pointer
                if (tChars.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < tChars.get(s.charAt(left))) {
                        have--;
                    }
                }
                left++;
            }
            right++;
        }
        return currentResult;
    }
}
