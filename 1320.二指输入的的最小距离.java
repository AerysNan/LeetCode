/*
 * @lc app=leetcode.cn id=1320 lang=java
 *
 * [1320] 二指输入的的最小距离
 */

// @lc code=start
class Solution {
  public int minimumDistance(String word) {
    int n = word.length();
    int[][][] dp = new int[n][26][26];
    int init = word.charAt(0) - 'A';
    for (int i = 0; i < n; i++)
      for (int j = 0; j < 26; j++)
        for (int k = 0; k < 26; k++)
          dp[i][j][k] = Integer.MAX_VALUE;
    for (int i = 0; i < 26; i++) {
      dp[0][init][i] = 0;
      dp[0][i][init] = 0;
    }
    for (int i = 1; i < n; i++) {
      int current = word.charAt(i) - 'A', prev = word.charAt(i - 1) - 'A';
      for (int j = 0; j < 26; j++) {
        dp[i][current][j] =
            Math.min(dp[i][current][j], dp[i - 1][prev][j] + distance(current, prev));
        dp[i][current][prev] =
            Math.min(dp[i][current][prev], dp[i - 1][j][prev] + distance(current, j));
        dp[i][j][current] =
            Math.min(dp[i][j][current], dp[i - 1][j][prev] + distance(current, prev));
        dp[i][prev][current] =
            Math.min(dp[i][prev][current], dp[i - 1][prev][j] + distance(current, j));
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 26; i++)
      for (int j = 0; j < 26; j++)
        result = Math.min(result, dp[n - 1][i][j]);
    return result;
  }

  int distance(int a, int b) {
    int xa = a / 6, ya = a % 6;
    int xb = b / 6, yb = b % 6;
    return Math.abs(xa - xb) + Math.abs(ya - yb);
  }
}
// @lc code=end

