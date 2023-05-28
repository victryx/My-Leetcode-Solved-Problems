package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LC217_ContainsDuplicate {

    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * Solution using Set <br />
     * Solved: 2023-05-28
     */
    public boolean containsDuplicate(int[] nums){
        Set<Integer> nonRepeating = new HashSet<>();
        for (int num : nums) {
            if (nonRepeating.contains(num)) return true;
            nonRepeating.add(num);
        }
        return false;
    }

    /**
     * <b>2nd Try.</b> <br />
     * Shortened Set solution. It is slower <br />
     * Solved: 2023-05-28
     */
    public boolean containsDuplicate2(int[] nums){
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }

}
