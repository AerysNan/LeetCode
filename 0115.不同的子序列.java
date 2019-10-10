/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
  public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++)
      dp[i][0] = 1;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        dp[i + 1][j + 1] = dp[i][j + 1] + (s.charAt(i) == t.charAt(j) ? dp[i][j] : 0);
    return dp[m][n];
  }
}
// @lc code=end

