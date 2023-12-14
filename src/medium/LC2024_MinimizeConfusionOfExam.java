package medium;

public class LC2024_MinimizeConfusionOfExam {
    /**
     * lee215's solution <br />
     * I used a bit of help because it is very late<br />
     * TODO Homework: Understand what this does
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 0;
        int maxFreq = 0;    // Frequency of the character that occurs more times
        int[] count = new int[128];


        for (int i = 0; i < answerKey.length(); i++) {
            maxFreq = Math.max(maxFreq, ++count[answerKey.charAt(i)]);
            if (result - maxFreq < k) {
                result++;
            } else {
                count[answerKey.charAt(i - result)]--;
            }
        }
        return result;
    }
}
