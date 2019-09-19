/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
  public int numDecodings(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    if (s.charAt(0) == '0')
      return 0;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      char c = s.charAt(i);
      if (c != '0')
        dp[i] += dp[i - 1];
      if (c <= '6' && s.charAt(i - 1) == '2' || s.charAt(i - 1) == '1')
        dp[i] += (i == 1 ? 1 : dp[i - 2]);
    }
    return dp[n - 1];
  }
}
// @lc code=end

