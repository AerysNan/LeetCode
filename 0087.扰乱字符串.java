/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    int n = s1.length();
    boolean[][][] dp = new boolean[n][n][n + 1];
    for (int k = 1; k <= n; ++k)
      for (int i = 0; i + k <= n; ++i)
        for (int j = 0; j + k <= n; ++j)
          if (k == 1)
            dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
          else {
            for (int m = 1; m < k && !dp[i][j][k]; ++m) {
              if (!(dp[i][j][m] && dp[i + m][j + m][k - m]
                  || dp[i][j + k - m][m] && dp[i + m][j][k - m]))
                continue;
              dp[i][j][k] = true;
              break;
            }
          }
    return dp[0][0][n];
  }
}
// @lc code=end

