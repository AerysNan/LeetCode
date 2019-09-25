/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
  public int numTrees(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++)
      dp[i][i] = 1;
    for (int k = 2; k <= n; k++) {
      for (int i = 1; i + k - 1 <= n; i++) {
        dp[i][i + k - 1] += dp[i + 1][i + k - 1] + dp[i][i + k - 2];
        for (int j = i + 1; j <= i + k - 2; j++)
          dp[i][i + k - 1] += dp[i][j - 1] * dp[j + 1][i + k - 1];
      }
    }
    return dp[1][n];
  }
}
// @lc code=end

