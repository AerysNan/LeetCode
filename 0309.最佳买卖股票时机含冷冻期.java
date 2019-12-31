import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    int[] dp_hold = new int[n], dp_sold = new int[n];
    dp_hold[0] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp_hold[i] = Math.max(dp_hold[i - 1], (i == 1 ? 0 : dp_sold[i - 2]) - prices[i]);
      dp_sold[i] = Math.max(dp_sold[i - 1], dp_hold[i - 1] + prices[i]);
    }
    return dp_sold[n - 1];
  }
}
// @lc code=end

