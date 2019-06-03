/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
  public String longestPalindrome(String s) {
    if (s.equals(""))
      return "";
    int n = s.length(), maxLen = -1, begin = -1;
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++)
      dp[i][i] = true;
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        maxLen = 2;
        begin = i;
      }
    }
    for (int i = 3; i <= n; i++) {
      for (int j = 0; i + j <= n; j++) {
        if (dp[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1)) {
          dp[j][j + i - 1] = true;
          maxLen = i;
          begin = j;
        }
      }
    }
    if (maxLen < 0)
      return s.charAt(0) + "";
    return s.substring(begin, begin + maxLen);
  }
}
