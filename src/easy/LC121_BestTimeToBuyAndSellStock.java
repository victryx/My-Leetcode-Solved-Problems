package easy;

public class LC121_BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices){
        int maxProfit = 0;
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minCost) {
                minCost = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minCost);
            }
        }
        return maxProfit;
    }


}
