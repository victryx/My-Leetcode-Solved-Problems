package easy;

public class LC1822_SignOfArrayProduct {

    /**
     * <b>1st Try.</b> <br />
     * Counting negatives <br />
     * Solved: 2023-06-01
     */
    public int arraySign(int[] nums) {
        int negatives = 0;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) negatives++;
        }
        return negatives % 2 == 0 ? 1 : -1;
    }

    /**
     * Shifting {@code sign} variable
     */
    public int arraySign2(int[] nums) {
        int sign = 1;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) sign = -sign;
        }
        return sign;
    }
}
