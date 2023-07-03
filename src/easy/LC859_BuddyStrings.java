package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC859_BuddyStrings {

    /**
     * <b>1st Try.</b> <br />
     * Find the difference<br />
     * Solved: 2023-07-02
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            Set<Character> sChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                sChars.add(c);
            }
            return sChars.size() < s.length(); // if there is one repeated char, the swap is possible
        }
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {    // The two strings should only differ at two points
                difference.add(i);
            }
        }

        return difference.size() == 2 && s.charAt(difference.get(0)) == goal.charAt(difference.get(1)) && s.charAt(difference.get(1)) == goal.charAt(difference.get(0));
    }
}
