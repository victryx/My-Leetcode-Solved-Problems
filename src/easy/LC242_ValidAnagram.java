package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ꬃꬒꬃꩢꬃ","ꬃꬒꬃꩢꬃ"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Solution using Arraylist. Works with unicode characters <br />
     * Solved: 2023-05-28
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            characters.remove((Character) t.charAt(i));
        }

        return characters.size() == 0;
    }


    /**
     * <b>2nd Try.</b> <br />
     * Solution using int array<br />
     * Solved: 2023-05-28
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] characters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i)]++;
            characters[t.charAt(i)]--;
        }

        return Arrays.stream(characters).noneMatch(i -> i != 0);

    }

    /**
     * Improved Solution using int array<br />
     * SOURCE: <a href="https://leetcode.com/problems/valid-anagram/solutions/66484/accepted-java-o-n-solution-in-5-lines/">Leetcode</a>
     */
    public boolean isAnagram3(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
