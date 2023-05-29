package easy;

public class LC28_IndexofFirstOccurrence {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issi"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Sliding window solution<br />
     * Solved: 2023-05-29
     */
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;

            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()){
                return i - j;
            }
        }
        return -1;
    }
}
