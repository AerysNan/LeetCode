/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int x = 0, y = 0, dir = 0;
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int lb = 0, rb = n - 1, ub = 0, db = n - 1, c = 1;
    while (c <= n * n) {
      result[x][y] = c;
      x += dirs[dir][0];
      y += dirs[dir][1];
      if (dir == 0 && y == rb) {
        dir = 1;
        ub++;
      } else if (dir == 1 && x == db) {
        dir = 2;
        rb--;
      } else if (dir == 2 && y == lb) {
        dir = 3;
        db--;
      } else if (dir == 3 && x == ub) {
        dir = 0;
        lb++;
      }
      c++;
    }
    return result;
  }
}
// @lc code=end
