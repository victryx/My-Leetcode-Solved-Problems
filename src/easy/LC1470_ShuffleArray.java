package easy;

public class LC1470_ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];

        int j = 0;
        int k = n;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                res[i] = nums[j++];
            else res[i] = nums[k++];
        }
        return res;
    }
}
