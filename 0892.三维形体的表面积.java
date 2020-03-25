/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
  public int surfaceArea(int[][] grid) {
    int m = grid.length, n = grid[0].length, result = 0;
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0)
          continue;
        result += 2;
        for (int[] dir : dirs) {
          int newI = i + dir[0], newJ = j + dir[1];
          result += Math.max(0,
              grid[i][j] - (newI < 0 || newI >= m || newJ < 0 || newJ >= n ? 0 : grid[newI][newJ]));
        }
      }
    }
    return result;
  }
}
// @lc code=end

