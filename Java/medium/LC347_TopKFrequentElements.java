package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC347_TopKFrequentElements {

    /**
     * <b>1st Try.</b> <br />
     * Bucket Sort solution<br />
     * Reference: <a href="https://youtu.be/YPTqKIgVk-k">Youtube (Neetcode)</a> <br />
     * Solved: 2023-06-20
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(nums.length + 1);

        for (int i = 0; i < nums.length + 1; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int i = bucket.size() - 1;
        int j = 0;
        while (i >= 0 && j < result.length) {
            ArrayList<Integer> values = bucket.get(i);
            if (values != null) {
                for (Integer value : values) {
                    result[j] = value;
                    j++;
                    if (j == result.length) return result;
                }
            }
            i--;
        }
        return result;
    }
}
