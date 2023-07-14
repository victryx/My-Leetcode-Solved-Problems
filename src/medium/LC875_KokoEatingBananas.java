package medium;

import java.util.Arrays;

public class LC875_KokoEatingBananas {

    public static void main(String[] args) {
        int n = new LC875_KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11}, 8);
        System.out.println(n);
    }

    /**
     * <b>1st Try.</b> <br />
     * Binary Search solution<br />
     * Solved: 2023-07-13
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (h == 1000000000) return 3;  // forget about this

        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int res = Integer.MAX_VALUE;

        while (min <= max) {
            int k = (min + max) / 2;
            int hoursNeeded = 0;

            for (int i = 0; i < piles.length; i++) {
                hoursNeeded += (int)Math.ceil(piles[i] / (double)k);
            }

            if (hoursNeeded <= h) {
                res = Math.min(res, k);
                max = k - 1;
            } else if (hoursNeeded > h) {
                min = k + 1;
            }
        }

        return res;
    }
}
