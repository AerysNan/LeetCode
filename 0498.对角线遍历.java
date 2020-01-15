/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return new int[] {};
    int r = 0, c = 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[] result = new int[rows * cols];
    for (int i = 0; i < result.length; i++) {
      result[i] = matrix[r][c];
      if ((r + c) % 2 == 0) {
        if (c == cols - 1)
          r++;
        else if (r == 0)
          c++;
        else {
          c++;
          r--;
        }
      } else {
        if (r == rows - 1)
          c++;
        else if (c == 0)
          r++;
        else {
          r++;
          c--;
        }
      }
    }
    return result;
  }
}
// @lc code=end

