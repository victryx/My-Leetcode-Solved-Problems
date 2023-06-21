package easy;

public class LC88_MergeSortedArray {

    /**
     * <b>1st Try.</b> <br />
     * Lazy solution. <br />
     * This one is easy, but I didn't have time today.  <br />
     * Solved: 2023-06-21 (Summer!)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];
        
        int resultIndex = 0;
        
        int i = 0;
        int j = 0;
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]){
                result[resultIndex] = nums1[i];
                i++;
            } else {
                result[resultIndex] = nums2[j];
                j++;
            }
            resultIndex++;
        }
        
        while(i < m){
            result[resultIndex] = nums1[i];
            i++;
            resultIndex++;
        }

        while (j < n) {
            result[resultIndex] = nums2[j];
            j++;
            resultIndex++;
        }

        for (int k = 0; k < result.length; k++) {
            nums1[k] = result[k];
        }
    }

}
