package easy;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LC1436_DestinationCity {

    /**
     * <b>1st Try.</b> <br />
     * Set solution<br />
     * Solved: 2023-12-15 <3
     */
    public String destCity(List<List<String>> paths) {
        Set<String> firsts = new HashSet<>();
        Set<String> seconds = new HashSet<>();

        for (int i = 0; i < paths.size(); i++) {
            String city1 = paths.get(i).get(0);
            String city2 = paths.get(i).get(1);

            firsts.add(city1);
            seconds.add(city2);
        }

        for (String c : seconds) {
            if (!firsts.contains(c)) return c;
        }
        return null;
    }
}
