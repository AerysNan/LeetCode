/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */
class Solution {
  public int findRotateSteps(String ring, String key) {
    int m = key.length();
    int n = ring.length();
    if (n == 0)
      return 0;
    int[][] dp = new int[m + 1][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
          if (ring.charAt(k) == key.charAt(i)) {
            int sub = Math.abs(j - k);
            int distance = Math.min(sub, n - sub);
            dp[i][j] = Math.min(dp[i][j], distance + dp[i + 1][k]);
          }
        }
      }
    }
    return dp[0][0] + m;
  }
}
