package easy;

public class LC441ArrangingCoins {
    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * Naive and stupid solution <br />
     * Solved: 2023-05-22
     */
    public static int arrangeCoins(int n) {
        long possibleRows = 1;
        long currentCoins = 1;

        while (currentCoins < n){
            currentCoins += possibleRows+1;
            possibleRows++;
        }

        if (currentCoins == n) return (int)possibleRows;
        return (int)possibleRows-1;
    }

    /*
     * The formula for the sum of an arithmetic series is:
     * S = (n/2) * (a + l)
     *
     * S represents the sum of the series. -> Coins given
     * n represents the number of terms in the series. -> rows
     * a represents the first term of the series. -> 1
     * l represents the last term of the series.->rows
     */

    /**
     * <b>2nd try</b> <br>
     * Not so stupid solution
     * Explanation pending.
     * Solved: 2023-05-22
     */
    public static int arrangeCoins2(int coins) {
        return (int) ((-1.0 + Math.sqrt(1.0 + 8.0 * coins))/2.0);
    }
}
