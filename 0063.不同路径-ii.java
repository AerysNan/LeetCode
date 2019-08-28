/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
      return 0;
    if (obstacleGrid[0][0] == 1)
      return 0;
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] step = new int[m][n];
    step[0][0] = 1;
    for (int i = 1; i < m; i++) {
      if (obstacleGrid[i][0] == 1)
        break;
      step[i][0] = 1;
    }
    for (int i = 1; i < n; i++) {
      if (obstacleGrid[0][i] == 1)
        break;
      step[0][i] = 1;
    }
    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        if (obstacleGrid[i][j] != 1)
          step[i][j] = step[i - 1][j] + step[i][j - 1];
    return step[m - 1][n - 1];
  }
}
// @lc code=end
