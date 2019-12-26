/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int m = matrix.length, n = matrix[0].length, result = 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '0')
          continue;
        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
        result = Math.max(result, dp[i + 1][j + 1]);
      }
    }
    return result * result;
  }
}
// @lc code=end

