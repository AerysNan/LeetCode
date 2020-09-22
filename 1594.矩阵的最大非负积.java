/*
 * @lc app=leetcode.cn id=1594 lang=java
 *
 * [1594] 矩阵的最大非负积
 */

// @lc code=start
class Solution {
  long[][] dp_max, dp_min;

  public int maxProductPath(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    dp_max = new long[m][n];
    dp_min = new long[m][n];
    dp_max[0][0] = grid[0][0];
    dp_min[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
      dp_max[i][0] = dp_max[i - 1][0] * grid[i][0];
      dp_min[i][0] = dp_min[i - 1][0] * grid[i][0];
    }
    for (int i = 1; i < n; i++) {
      dp_max[0][i] = dp_max[0][i - 1] * grid[0][i];
      dp_min[0][i] = dp_min[0][i - 1] * grid[0][i];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (grid[i][j] == 0) {
          dp_max[i][j] = 0;
          dp_min[i][j] = 0;
        } else if (grid[i][j] > 0) {
          dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i][j - 1]) * grid[i][j];
          dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i][j - 1]) * grid[i][j];
        } else {
          dp_max[i][j] = Math.min(dp_min[i - 1][j], dp_min[i][j - 1]) * grid[i][j];
          dp_min[i][j] = Math.max(dp_max[i - 1][j], dp_max[i][j - 1]) * grid[i][j];
        }
      }
    }
    if (dp_max[m - 1][n - 1] < 0)
      return -1;
    return (int) (dp_max[m - 1][n - 1] % 1000000007);
  }
}
// @lc code=end
