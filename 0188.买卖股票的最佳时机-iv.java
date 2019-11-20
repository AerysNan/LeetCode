/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    if (k >= n / 2)
      return profit(prices);
    int[][] dp_hold = new int[n][k + 1];
    int[] dp_sold = new int[k + 1];
    for (int i = 0; i <= k; i++)
      dp_hold[0][i] = -prices[0];
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= k; j++) {
        dp_hold[i][j] = Math.max(dp_hold[i - 1][j], dp_sold[j - 1] - prices[i]);
        dp_sold[j] = Math.max(dp_sold[j], dp_hold[i - 1][j] + prices[i]);
      }
    }
    return dp_sold[k];
  }

  int profit(int[] prices) {
    int n = prices.length;
    int dp_hold = -prices[0], dp_sold = 0;
    for (int i = 1; i < n; i++) {
      int tmp = Math.max(dp_hold, dp_sold - prices[i]);
      dp_sold = Math.max(dp_sold, dp_hold + prices[i]);
      dp_hold = tmp;
    }
    return dp_sold;
  }
}
// @lc code=end

