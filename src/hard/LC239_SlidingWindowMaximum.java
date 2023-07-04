package hard;

import java.util.*;

public class LC239_SlidingWindowMaximum {
    public static void main(String[] args) {

    }



    /**
     * <b>1st Try.</b> <br />
     * Brute force<br />
     * Solved: 2023-07-01
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        List<Integer> curWindow = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            addElement(nums[i], curWindow);
        }


        for (int i = 0; i < nums.length - k; i++) {

            ans[j] = curWindow.get(curWindow.size() - 1);
            j++;

            curWindow.remove(Integer.valueOf(nums[i]));
            addElement(nums[i + k], curWindow);
        }
        ans[j] = curWindow.get(curWindow.size() - 1);
        return ans;
    }

    public void addElement(Integer element, List<Integer> list) {
        int index = Collections.binarySearch(list, element);
        if (index < 0) index = ~index;
        list.add(index, element);
    }
}
