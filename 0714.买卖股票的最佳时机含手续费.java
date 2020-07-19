import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_hold = -prices[0], dp_sold = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp_hold;
            dp_hold = Math.max(dp_hold, dp_sold - prices[i]);
            dp_sold = Math.max(dp_sold, temp + prices[i] - fee);
        }
        return dp_sold;
    }
}
// @lc code=end
