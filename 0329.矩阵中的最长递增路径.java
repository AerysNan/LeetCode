/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 *
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (36.67%)
 * Total Accepted:    1.2K
 * Total Submissions: 3.2K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2:
 *
 * 输入: nums =
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 *
 */
class Solution {
  private static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  private int[][] cache;
  private int m, n;

  public int longestIncreasingPath(int[][] matrix) {
    m = matrix.length;
    if (m == 0)
      return 0;
    n = matrix[0].length;
    if (n == 0)
      return 0;
    int result = Integer.MIN_VALUE;
    cache = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        result = Math.max(result, dfs(matrix, i, j));
    return result;
  }

  private int dfs(int[][] matrix, int x, int y) {
    if (cache[x][y] != 0)
      return cache[x][y];
    int length = 1;
    for (int i = 0; i < 4; i++) {
      int newX = x + direction[i][0];
      int newY = y + direction[i][1];
      if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] <= matrix[x][y])
        continue;
      length = Math.max(length, 1 + dfs(matrix, newX, newY));
    }
    cache[x][y] = length;
    return length;
  }
}
