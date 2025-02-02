package medium;

public class LC2482_DifferenceBetweenOnesAndZeros {
    /**
     * <b>1st Try.</b> <br />
     * December first medium problem<br />
     * Solved: 2023-12-14 <3
     */
    public int[][] onesMinusZeros(int[][] grid) {

        int[] rowVals = new int[grid.length];
        int[] colVals = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = grid[i][j] == 0 ? -1 : 1;
                rowVals[i] += grid[i][j];
                colVals[j] += grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] += rowVals[i] + colVals[j] - grid[i][j];
            }
        }

        return grid;
    }
}
