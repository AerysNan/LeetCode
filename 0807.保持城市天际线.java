/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 */

// @lc code=start
class Solution {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] rMax = new int[m], cMax = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        rMax[i] = Math.max(rMax[i], grid[i][j]);
        cMax[j] = Math.max(cMax[j], grid[i][j]);
      }
    }
    int result = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        result += Math.min(rMax[i], cMax[j]) - grid[i][j];
    return result;
  }
}
// @lc code=end
