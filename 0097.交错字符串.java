/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int p = s1.length(), q = s2.length();
    if (s3.length() != p + q)
      return false;
    boolean[][] dp = new boolean[p + 1][q + 1];
    dp[0][0] = true;
    for (int i = 1; i <= p; i++) {
      if (s1.charAt(i - 1) != s3.charAt(i - 1))
        break;
      dp[i][0] = true;
    }
    for (int i = 1; i <= q; i++) {
      if (s2.charAt(i - 1) != s3.charAt(i - 1))
        break;
      dp[0][i] = true;
    }
    for (int i = 1; i <= p; i++)
      for (int j = 1; j <= q; j++)
        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
    return dp[p][q];
  }
}
// @lc code=end

