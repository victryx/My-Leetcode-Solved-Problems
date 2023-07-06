package hard;

import java.util.*;

public class LC239_SlidingWindowMaximum {
    public static void main(String[] args) {

    }



    /**
     * <b>1st Try.</b> <br />
     * Brute force<br />
     * Solved: 2023-07-04
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

    /**
     * Solved with neetcode explanation<br />
     * Reference: <a href="https://youtu.be/DfljaUwZsOk">NeetCode</a> <br>
     * Solved: 2023-07-05
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] output = new int [nums.length - k + 1];
        int l = 0;
        int r = 0;
        Deque<Integer> q = new LinkedList<>(); // q stores indices

        while (r < nums.length) {
            // Pop smaller values from the deque
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.addLast(r);

            // Remove left volue from window
            if (l > q.peekFirst()) {
                q.pollFirst();
            }

            if ((r + 1) >= k) {
                output[l] = nums[q.peekFirst()];
                l++;    // left is updated once the window is sized k
            }
        }

        return output;
    }
}