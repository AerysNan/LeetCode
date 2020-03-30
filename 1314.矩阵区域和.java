/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
class Solution {
  public int[][] matrixBlockSum(int[][] mat, int K) {
    int m = mat.length, n = mat[0].length;
    int[][] prefix = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++)
        prefix[i][j] =
            prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int u = Math.max(0, i - K), d = Math.min(m - 1, i + K);
        int l = Math.max(0, j - K), r = Math.min(n - 1, j + K);
        result[i][j] = prefix[d + 1][r + 1] - prefix[d + 1][l] - prefix[u][r + 1] + prefix[u][l];
      }
    }
    return result;
  }
}
// @lc code=end

