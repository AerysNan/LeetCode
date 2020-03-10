/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    if (n <= 1)
      return 0;
    int[] dp = new int[cost.length + 1];
    for (int i = 2; i <= n; i++)
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    return dp[n];
  }
}
// @lc code=end

