package medium;

import java.util.Arrays;

public class LC424_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("BAAAB", 2));
    }

    /**
     * <b>1st Try.</b> <br />
     * Slow solution<br />
     * Solved: 2023-06-30
     */
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int bestLength = 0;
        int movesLeft = k;
        char curChar = s.charAt(0);

        while (right < s.length()) {
            if (s.charAt(right) == curChar) {
                right++;
            } else if (movesLeft > 0) {
                right++;
                movesLeft--;
            } else {
                while (left < s.length() && s.charAt(left) == curChar) {
                    left++;
                }
                movesLeft = k;
                right = left;
                curChar = s.charAt(left);
            }

            bestLength = Math.max(bestLength, right-left);
        }
        while (movesLeft > 0 && left >= 0) {
            left--;
            if (left >= 0 && s.charAt(left) != curChar) {
                movesLeft--;
                bestLength = Math.max(bestLength, right-left);
            }
        }
        return bestLength;
    }

    /**
     * Sliding window simple solution
     * Source: <a href="https://youtu.be/gqXU1UyA8pk">Youtube (Neetcode)</a> <br />
     */
    public int characterReplacement2(String s, int k) {
        int[] count = new int[26];
        int ans = 0;
        int l = 0;
        int r = 0;

        for (r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;

            while ((r - l + 1) - maxValue(count) > k){
                count[s.charAt(l)]--;
                l++;
            }

            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }

    private int maxValue(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
