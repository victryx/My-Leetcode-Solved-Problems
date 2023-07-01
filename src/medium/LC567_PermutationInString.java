package medium;

import java.util.Arrays;

public class LC567_PermutationInString {

    public static void main(String[] args) {
        System.out.println(new LC567_PermutationInString().checkInclusion2("adc", "dcda"));
    }

    /**
     * <b>1st Try.</b> <br />
     * int array solution<br />
     * Solved: 2023-07-01
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] sub1 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            sub1[s1.charAt(i)]++;
        }

        int i = 0;
        int j = 0;
        while (i < s2.length()) {
            while (i < s2.length() && sub1[s2.charAt(i)] == 0) {
                i++;
            }

            j = i;
            while (j < s2.length() && sub1[s2.charAt(j)] > 0) {
                i = j;
                int curLen = 0;
                int[] curSubAr = sub1.clone();
                while (i < s2.length() && curSubAr[s2.charAt(i)] > 0) {
                    curLen++;
                    curSubAr[s2.charAt(i)]--;
                    if (curLen == s1.length()) return true;
                    i++;
                }
                j++;
            }
        }
        return false;
    }


    /**
     * <b>2nd Try.</b> <br />
     * Sliding window<br />
     * Solved: 2023-07-01
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Chars, s2Chars)) return true;
        for (int i = 1; i + len - 1 < s2.length(); i++) {
            s2Chars[s2.charAt(i - 1) - 'a']--;
            s2Chars[s2.charAt(i + len - 1) - 'a']++;
            if (Arrays.equals(s1Chars, s2Chars)) return true;
        }

        return false;
    }

    /**
     * int array solution<br />
     *
     */
}




