/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
  int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int islandPerimeter(int[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        if (grid[i][j] == 1)
          result += perimeter(grid, i, j);
    return result;
  }

  int perimeter(int[][] grid, int x, int y) {
    int result = 0;
    for (int[] dir : dirs) {
      int newX = dir[0] + x, newY = dir[1] + y;
      if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length
          || grid[newX][newY] == 0)
        result++;
    }
    return result;
  }
}
// @lc code=end

