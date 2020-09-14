/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
class Solution {
  int result, m, n, targetX, targetY, target;
  int[][] grid, dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  Integer[][][] memo;

  public int uniquePathsIII(int[][] grid) {
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;
    target = 0;
    int startX = 0, startY = 0;
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (grid[x][y] % 2 == 0)
          target |= code(x, y);
        if (grid[x][y] == 1) {
          startX = x;
          startY = y;
        } else if (grid[x][y] == 2) {
          targetX = x;
          targetY = y;
        }
      }
    }
    memo = new Integer[m][n][1 << m * n];
    return dp(startX, startY, target);
  }

  public int code(int x, int y) {
    return 1 << (x * n + y);
  }

  public Integer dp(int x, int y, int state) {
    if (memo[x][y][state] != null)
      return memo[x][y][state];
    if (x == targetX && y == targetY)
      return state == 0 ? 1 : 0;
    int result = 0;
    for (int[] dir : dirs) {
      int newX = x + dir[0], newY = y + dir[1];
      if (0 <= newX && newX < m && 0 <= newY && newY < n)
        if ((state & code(newX, newY)) != 0)
          result += dp(newX, newY, state ^ code(newX, newY));
    }
    memo[x][y][state] = result;
    return result;
  }
}
// @lc code=end
