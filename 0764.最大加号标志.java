/*
 * @lc app=leetcode.cn id=764 lang=java
 *
 * [764] 最大加号标志
 */

// @lc code=start
class Solution {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    int[][] grid = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        grid[i][j] = Integer.MAX_VALUE;
    for (int[] mine : mines)
      grid[mine[0]][mine[1]] = 0;
    for (int i = 0; i < N; i++) {
      int l = 0, r = 0, u = 0, d = 0;
      for (int j = 0, k = N - 1; j < N; j++, k--) {
        grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
        grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
        grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
        grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
      }
    }
    int result = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        result = Math.max(result, grid[i][j]);
    return result;
  }
}
// @lc code=end

