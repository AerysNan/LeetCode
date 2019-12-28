/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < n; i++)
      for (int j = 1; i + j * j <= n; j++)
        dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
    return dp[n];
  }
}
// @lc code=end

