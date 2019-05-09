/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */
class Solution {
  public int maxProfit(int[] prices) {
    int result = 0;
    int i = 0, n = prices.length;
    while (i < n) {
      int j = i;
      while (j < n - 1 && prices[j] <= prices[j + 1])
        j++;
      result += prices[j] - prices[i];
      i = j + 1;
    }
    return result;
  }
}
