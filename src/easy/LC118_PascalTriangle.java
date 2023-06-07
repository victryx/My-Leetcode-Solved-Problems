package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC118_PascalTriangle {


    /**
     * <b>1st Try.</b> <br />
     * Simple solution<br />
     * Solved: 2023-06-07
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i <= numRows; i++) {
            result.add(new ArrayList<>());
            result.get(i).add(1);
            for (int j = 1; j < i - 1; j++) {
                result.get(i).add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
            }
            if (i != 0)
                result.get(i).add(1);
        }

        result.remove(1);
        return result;
    }
}
