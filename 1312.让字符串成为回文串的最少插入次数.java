/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
class Solution {
  public int minInsertions(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int length = 2; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;
        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
        if (s.charAt(i) == s.charAt(j))
          dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
      }
    }
    return dp[0][n - 1];
  }
}
// @lc code=end

