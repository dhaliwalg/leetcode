/**
 * LeetCode Problem: Best Time to Buy and Sell Stock
 * 
 * Description:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 * 
 * We are trying to maximize profit = sell - buy. 
 * If the current i is the sell value, we want to choose the minimum buy value to the left of i to maximize the profit. 
 */

class BestTimeToBuySell {
    
    public int maxProfit(int[] prices) {
        // Left pointer 'l' represents buying day (initially day 0)
        int l = 0;
        
        // Right pointer 'r' represents selling day (initially day 1)
        int r = 1;
        
        // Variable to keep track of maximum profit found so far
        int maxProfit = 0;
        
        // Continue until we've checked all possible selling days
        while(r < prices.length) {
            // If buying price is less than selling price
            // We have found a profitable trade
            if(prices[l] < prices[r]) {
                // Calculate profit for current buy/sell combination
                int profit = prices[r] - prices[l];
                
                // Update maxProfit if current profit is larger
                maxProfit = Math.max(maxProfit, profit);
            } 
            // If buying price is greater than or equal to selling price
            // We've found a better buying day
            else {
                // Move buying day pointer to current selling day
                // Since we want to buy at the lowest price possible
                l = r;
            }
            
            // Move selling day pointer to check next day
            r++;
        }
        
        return maxProfit;
    }

    /**
     * This method uses a dynamic approach to track the minimum buy price and the maximum profit.
     */
    public int DynamicSolution(int[] prices){
        int maxProfit = 0;
        int buyPrice = prices[0];

        for(int sell: prices){
            maxProfit = Math.max(maxProfit, sell - buyPrice);
            buyPrice = Math.min(buyPrice, sell); //NEED the smallest value so we track that dyna
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySell solution = new BestTimeToBuySell();
        
        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices1)); // Expected output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices2)); // Expected output: 0

        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices3)); // Expected output: 4

        int[] prices4 = {7, 1, 5, 3, 6, 4, 8};
        System.out.println(solution.maxProfit(prices4)); // Expected output: 7
    }
}