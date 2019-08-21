/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0)
      return result;
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int m = matrix.length, n = matrix[0].length;
    int lb = 0, rb = n - 1, ub = 0, db = m - 1, count = 0;
    int x = 0, y = 0, dir = matrix[0].length == 1 ? 1 : 0;
    while (count < m * n) {
      result.add(matrix[x][y]);
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
      count++;
    }
    return result;
  }
}
// @lc code=end
