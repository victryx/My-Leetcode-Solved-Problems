package medium;

import java.util.Arrays;
import java.util.Stack;

public class LC739_DailyTemperatures {

    public static void main(String[] args) {
        new LC739_DailyTemperatures().dailyTemperatures2(new int[]{4,6,3,2,1,9,12});
    }

    /**
     * <b>1st Try.</b> <br />
     * Brute force solution<br />
     * Solved: 2023-07-09
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while (j < temperatures.length && temperatures[i] >= temperatures[j]) {
                j++;
            }
            res[i] = j < temperatures.length ? j - i : 0;
        }

        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer[]> st = new Stack<>();  // save the indexes so temps are in ascending order
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!st.isEmpty() && st.peek()[0] < temperatures[i]){
                Integer[] pop = st.pop();
                int stackT = pop[0];
                int stackInd = pop[1];

                res[stackInd] = (i-stackInd);
            }

            st.push(new Integer[]{temperatures[i], i});
        }
        return res;
    }


}
