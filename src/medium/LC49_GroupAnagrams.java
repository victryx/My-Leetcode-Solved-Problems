package medium;

import java.util.*;

public class LC49_GroupAnagrams {


    public static void main(String[] args) {
        new LC49_GroupAnagrams().groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    /**
     * <b>1st Try.</b> <br />
     * Comparing sorted strings <br />
     * Solved: 2023-06-23
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            insertAnagram(result,str);
        }
        return result;
    }

    public void insertAnagram(List<List<String>> anagramGroup, String anagram) {
        for (int i = 0; i < anagramGroup.size(); i++) {
            String comparing = anagramGroup.get(i).get(0);
            if (comparing.length() == anagram.length()) {
                char[] anagramChars = anagram.toCharArray();
                char[] comparingChars = comparing.toCharArray();
                Arrays.sort(anagramChars);
                Arrays.sort(comparingChars);
                if (Arrays.equals(anagramChars,comparingChars)) {
                    anagramGroup.get(i).add(anagram);
                    return;
                }
            }
        }
        anagramGroup.add(new ArrayList<>());
        anagramGroup.get(anagramGroup.size() - 1).add(anagram);
    }

    /**
     <a href="https://www.youtube.com/watch?v=vzdNOK2oB2E&ab_channel=NeetCode">NeetCode solution</a>
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<List<Integer>, List<String>> res = new HashMap<>();
        for (String str : strs) {
            List<Integer> count = new ArrayList<Integer>(Collections.nCopies(26, 0));
            for (char c : str.toCharArray()) {
                count.set(c-'a', count.get(c-'a') + 1);
            }
            if (!res.containsKey(count)) {
                res.put(count, new ArrayList<>());
            }
            res.get(count).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
