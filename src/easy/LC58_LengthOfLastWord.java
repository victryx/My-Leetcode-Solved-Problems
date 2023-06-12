package easy;

public class LC58_LengthOfLastWord {

    /**
     * <b>1st Try.</b> <br />
     * String split solution<br />
     * Solved: 2023-06-10
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length -1].length();
    }

    /**
     * substring solution<br />
     * Source: https://leetcode.com/problems/length-of-last-word/solutions/3578178/fastest-shortest-way-to-solve-beats-100/
     */
    public int lengthOfLastWord2(String s) {
        s = s.trim();
        if(s.indexOf(' ')==-1)
        return s.length();
        return s.substring(s.lastIndexOf(' ')).length()-1;
    }
}
