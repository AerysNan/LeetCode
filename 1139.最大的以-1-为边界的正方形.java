/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */
class Solution {
  public int largest1BorderedSquare(int[][] grid) {
    int result = 0, n = grid.length, m = grid[0].length;
    int[][] stretchRow = new int[n][m];
    int[][] stretchCol = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = m - 1; j >= 0; j--)
        stretchRow[i][j] = (j == m - 1 || grid[i][j] == 0 ? 0 : stretchRow[i][j + 1]) + grid[i][j];
    for (int j = 0; j < m; j++)
      for (int i = n - 1; i >= 0; i--)
        stretchCol[i][j] = (i == n - 1 || grid[i][j] == 0 ? 0 : stretchCol[i + 1][j]) + grid[i][j];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        for (int k = 1; k <= 100; k++) {
          if (k + i - 1 >= n || k + j - 1 >= m || stretchRow[i][j] < k || stretchCol[i][j] < k
              || stretchRow[i + k - 1][j] < k || stretchCol[i][j + k - 1] < k)
            continue;
          result = Math.max(result, k);
        }
    return result * result;
  }
}
