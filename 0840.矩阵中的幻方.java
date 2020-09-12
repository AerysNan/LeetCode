/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
  public int numMagicSquaresInside(int[][] grid) {
    int m = grid.length, n = grid[0].length, result = 0;
    for (int i = 0; i < m - 2; ++i)
      for (int j = 0; j < n - 2; ++j) {
        if (grid[i + 1][j + 1] != 5)
          continue;
        if (valid(grid[i][j], grid[i][j + 1], grid[i][j + 2], grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
            grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]))
          result++;
      }
    return result;
  }

  public boolean valid(int... vals) {
    int[] count = new int[10];
    for (int v : vals) {
      if (v > 9)
        return false;
      count[v]++;
    }
    for (int v = 1; v <= 9; v++)
      if (count[v] != 1)
        return false;
    return (vals[0] + vals[1] + vals[2] == 15 && vals[3] + vals[4] + vals[5] == 15 && vals[6] + vals[7] + vals[8] == 15
        && vals[0] + vals[3] + vals[6] == 15 && vals[1] + vals[4] + vals[7] == 15 && vals[2] + vals[5] + vals[8] == 15
        && vals[0] + vals[4] + vals[8] == 15 && vals[2] + vals[4] + vals[6] == 15);
  }
}
// @lc code=end
