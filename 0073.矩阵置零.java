/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return;
    int m = matrix.length, n = matrix[0].length;
    boolean[] r = new boolean[m], c = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          r[i] = true;
          c[j] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      if (!r[i])
        continue;
      for (int j = 0; j < n; j++)
        matrix[i][j] = 0;
    }
    for (int i = 0; i < n; i++) {
      if (!c[i])
        continue;
      for (int j = 0; j < m; j++)
        matrix[j][i] = 0;
    }
  }
}
// @lc code=end
