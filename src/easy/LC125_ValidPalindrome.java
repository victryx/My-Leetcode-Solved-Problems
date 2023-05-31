package easy;

public class LC125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Regex replacement and two pointers <br />
     * Solved: 2023-05-31
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W_]","").toLowerCase();
        int i = 0;
        int j = s.length()-1;
        System.out.println(s);
        while (i<j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
