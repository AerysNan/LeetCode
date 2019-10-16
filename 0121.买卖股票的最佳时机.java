/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    int result = 0, min = prices[0];
    for (int i = 1; i < n; i++) {
      if (prices[i] < min)
        min = prices[i];
      else
        result = Math.max(result, prices[i] - min);
    }
    return result;
  }
}
// @lc code=end

