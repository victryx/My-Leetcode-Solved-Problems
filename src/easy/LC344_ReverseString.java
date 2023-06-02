package easy;

public class LC344_ReverseString {

    /**
     * <b>1st Try.</b> <br />
     * Iterative Solution <br />
     * Solved: 2023-06-02
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i<j){
            char temp =  s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
