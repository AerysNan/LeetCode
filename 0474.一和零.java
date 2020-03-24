/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String s : strs) {
      int[] counts = count(s);
      for (int i = m; i >= counts[0]; i--)
        for (int j = n; j >= counts[1]; j--)
          dp[i][j] = Math.max(dp[i][j], dp[i - counts[0]][j - counts[1]] + 1);
    }
    return dp[m][n];
  }

  int[] count(String s) {
    int[] result = new int[2];
    for (char c : s.toCharArray()) {
      if (c == '0')
        result[0]++;
      else
        result[1]++;
    }
    return result;
  }
}
// @lc code=end

