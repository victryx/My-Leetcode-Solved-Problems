package hard;

public class LC76_MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
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
}
