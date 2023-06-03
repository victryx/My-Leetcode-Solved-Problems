package easy;

import java.util.Arrays;
import java.util.HashSet;

public class LC345_ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    /**
     * <b>1st Try.</b> <br />
     * Two pointers <br />
     * Solved: 2023-06-03
     */
    public static String reverseVowels(String s) {
        char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};


        char[] result = s.toCharArray();
        int left = 0;
        int right = result.length - 1;
        while (left < right) {
            System.out.println(Arrays.binarySearch(vowels,result[left]));
            while (Arrays.binarySearch(vowels,result[left]) < 0 && left < right){
                left++;
            }
            while (Arrays.binarySearch(vowels,result[right]) < 0 && left < right){
                right--;
            }
            if (left < right) {
                char temp = result[left];
                result[left] = result[right];
                result[right] = temp;
                left++;
                right--;
            }
        }
        return new String(result);
    }

    /**
     * <b>2nd Try.</b> <br />
     * Hashset solution <br />
     * Solved: 2023-06-03
     */
    public String reverseVowels2(String s) {
        Character[] vowelsArr = {'A','E','I','O','U','a','e','i','o','u'};
        HashSet<Character> vowelsSet = new HashSet<>();
        for (Character vowel : vowelsArr) {
            vowelsSet.add(vowel);
        }

        char[] result = s.toCharArray();
        int left = 0;
        int right = result.length - 1;
        while (left < right) {
            while (!vowelsSet.contains(result[left]) && left < right){
                left++;
            }
            while (!vowelsSet.contains(result[right]) && left < right){
                right--;
            }
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left++;
            right--;
        }
        return new String(result);
    }
}
