package easy;

import java.util.HashMap;
import java.util.Map;

public class LC2325_DecodeMessage {

    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }


    /**
     * <b>1st Try.</b> <br />
     * HashMap solution <br />
     * Solved: 2023-06-06
     */
    public static String decodeMessage(String key, String message) {
        Map<Character, Character> code = new HashMap<>();
        code.put(' ', ' ');

        int i = 0;

        for (char c  : key.toCharArray()) {
            if (c != ' ' && !code.containsKey(c)) {
                code.put(c, (char) (97 + i));
                i++;
            }
        }

        char[] result = new char[message.length()];

        for (i = 0; i < message.length(); i++) {
            result[i] = code.get(message.charAt(i));
        }
        return new String(result);
    }
}
