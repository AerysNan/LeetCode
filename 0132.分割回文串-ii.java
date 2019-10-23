/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
  public int minCut(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    int[] dp = new int[n + 1];
    dp[0] = -1;
    for (int i = 1; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (!isPalindrome(s, j, i))
          continue;
        dp[i] = Math.min(dp[i], dp[j] + 1);
      }
    }
    return dp[n];
  }

  boolean isPalindrome(String s, int l, int r) {
    int n = (r - l) / 2;
    for (int i = 0; i < n; i++)
      if (s.charAt(i + l) != s.charAt(r - 1 - i))
        return false;
    return true;
  }

}
// @lc code=end

