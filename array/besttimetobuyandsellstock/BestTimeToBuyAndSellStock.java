package array.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock {

    // time complexity : O(n), performing a single iteration.
    // space complexity : O(1), no extra space is used.
    public int maxProfit(int[] prices) {

        int bestBuy = prices[0];
        int bestProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            
            bestBuy = Math.min(bestBuy, prices[i]);
            bestProfit = Math.max(bestProfit, prices[i] - bestBuy);
        }

        return bestProfit;
        
    }
}
