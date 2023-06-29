package medium;

public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ag"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Sliding window solution<br />
     * Solved: 2023-06-28
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] letters = new int[128];
        int left = 0;
        int right = 0;
        int bestLength = 0;

        while (right < s.length()) {
            letters[s.charAt(right)]++;
            while (letters[s.charAt(right)] > 1) {
                letters[s.charAt(left)]--;
                left++;
            }
            right++;

            bestLength = Math.max(bestLength, right-left);
        }

        return bestLength;
    }


}
