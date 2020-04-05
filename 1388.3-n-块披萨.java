/*
 * @lc app=leetcode.cn id=5351 lang=java
 *
 * [5351] 3n 块披萨
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int maxSizeSlices(int[] slices) {
    int n = slices.length, result = 0;
    int[][] dp = new int[n][n / 3 + 1];
    Arrays.fill(dp[0], slices[0]);
    dp[0][0] = 0;
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j <= n / 3; j++)
        dp[i][j] = Math.max(dp[i - 1][j], i - 2 >= 0 ? dp[i - 2][j - 1] + slices[i] : slices[i]);
      result = Math.max(result, dp[i][n / 3]);
    }
    dp = new int[n][n / 3 + 1];
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= n / 3; j++)
        dp[i][j] = Math.max(dp[i - 1][j], i - 2 >= 0 ? dp[i - 2][j - 1] + slices[i] : slices[i]);
      result = Math.max(result, dp[i][n / 3]);
    }
    return result;
  }
}
// @lc code=end

