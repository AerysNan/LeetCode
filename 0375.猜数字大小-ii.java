/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {
  int[][] dp;

  int solve(int l, int r) {
    if (l >= r)
      return 0;
    if (dp[l][r] != 0)
      return dp[l][r];
    dp[l][r] = Integer.MAX_VALUE;
    for (int i = l; i <= r; ++i)
      dp[l][r] = Math.min(dp[l][r], Math.max(i + solve(l, i - 1), i + solve(i + 1, r)));
    return dp[l][r];
  }

  public int getMoneyAmount(int n) {
    dp = new int[n + 1][n + 1];
    return solve(1, n);
  }
}
// @lc code=end

