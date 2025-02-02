package easy;

import java.util.Arrays;

public class LC744_NextGreaterLetter {
    /**
     * <b>1st Try.</b> <br />
     * Iterate through characters <br />
     * Solved: 2023-06-22
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (int ch = target + 1; ch < 'z' + 1; ch++) {
            int index = Arrays.binarySearch(letters, (char)ch);
            if (index > -1) {
                return letters[index];
            }
        }
        return letters[0];
    }
}
