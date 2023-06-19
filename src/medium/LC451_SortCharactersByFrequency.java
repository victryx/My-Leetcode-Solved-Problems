package medium;

import java.util.HashMap;

public class LC451_SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("Eeeee aaakd asldkfj"));
    }

    /**
     * <b>1st Try.</b> <br />
     * int array solution<br />
     * Solved: 2023-06-19
     */
    public static String frequencySort(String s) {
        int[] charFreq = new int[128];
        int maxOccurs = 0;

        for (char ch : s.toCharArray()) {
            charFreq[ch] ++;
            if (charFreq[ch] > maxOccurs) {
                maxOccurs = charFreq[ch];
            }
        }


        StringBuilder out = new StringBuilder();
        while (maxOccurs > 0) {
            for (int i = 0; i < charFreq.length; i++) {
                if (charFreq[i] == maxOccurs){
                    for (int j = 0; j < maxOccurs; j++) {
                        out.append((char)i);
                    }
                }
            }
            maxOccurs--;
        }
        return out.toString();
    }
}
