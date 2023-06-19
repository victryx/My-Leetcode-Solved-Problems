package easy;

public class LC1732_FindHighestAltitude {


    /**
     * <b>1st Try.</b> <br />
     * prefix sum<br />
     * Solved: 2023-06-19
     */
    public int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int maxAltitude = 0;
        for (int i : gain) {
            currAltitude += i;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }
        return maxAltitude;
    }
}
