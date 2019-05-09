/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
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
