package medium;

import java.util.*;

public class LC15_3Sum {

    /**
     * <b>1st Try.</b> <br />
     * Time limit exceeded <br />
     * Solved: 2023-06-01
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = 0, k = 0;
        while (i < nums.length) {
            j = i + 1;
            while (j < nums.length) {
                k = Arrays.binarySearch(nums, - nums[i] - nums[j]);
                if (k >= 0 && k != i && k != j) {
                    addIfNotRepeated(result, nums[i],nums[j],nums[k]);
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public void addIfNotRepeated(List<List<Integer>> lists, int a, int b, int c) {
        boolean repeated = false;
        boolean allZero = a == 0 && b == 0 && c == 0;
        for (List<Integer> list : lists){
            if (allZero) {
                repeated = list.equals(new ArrayList<>(Arrays.asList(0,0,0))) || repeated;
            } else{
                repeated = (list.contains(a) && list.contains(b) && list.contains(c)) || repeated;
            }
        }

        if (!repeated){
            lists.add(new ArrayList<>(Arrays.asList(a,b,c)));
        }
    }


    /**
     * <b>2nd Try.</b> <br />
     * Time limit exceeded <br />
     * Solved: 2023-06-01
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> numIndex = new HashMap<>();
        int i = 0;
        int j;
        int k;
        while (i < nums.length) {
            int[] sum = twoSum(nums, -nums[i]);
            j = sum[0];
            k = sum[1];
            if (i != j && i != k && j != -1){
                addIfNotRepeated2(result,nums[i],nums[j],nums[k]);
            }
            i++;
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toTarget = target-nums[i];
            if (map.containsKey(toTarget)){
                return new int[]{i,map.get(toTarget)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public void addIfNotRepeated2(List<List<Integer>> lists, int a, int b, int c) {
        List<Integer> candidate = new ArrayList<>(Arrays.asList(a,b,c));
        candidate.sort(Comparator.naturalOrder());
        boolean repeated = false;
        for (List<Integer> l : lists) {
            repeated = l.equals(candidate) || repeated;
        }
        if (!repeated){
            lists.add(candidate);
        }
    }
}
