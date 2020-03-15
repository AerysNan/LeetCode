/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
  public int countNegatives(int[][] grid) {
    int result = 0, m = grid.length, n = grid[0].length;
    for(int i = 0; i < m; i++)
      for(int j = 0; j < n; j++)
        if(grid[i][j] < 0)
          result++;
      return result;
  }
}
// @lc code=end

