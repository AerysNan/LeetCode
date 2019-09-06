/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++)
      dp[i][0] = i;
    for (int i = 1; i <= n; i++)
      dp[0][i] = i;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int val = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
        dp[i][j] = Math.min(val, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
      }
    }
    return dp[m][n];
  }
}
// @lc code=end
