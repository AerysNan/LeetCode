import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=944 lang=java
 *
 * [944] 删列造序
 */

// @lc code=start
class Solution {
  public int minDeletionSize(String[] A) {
    int result = 0, m = A.length, n = A[0].length();
    char[][] matrix = new char[m][n];
    for (int i = 0; i < m; i++)
      matrix[i] = A[i].toCharArray();
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m - 1; i++) {
        if (matrix[i][j] > matrix[i + 1][j]) {
          result++;
          break;
        }
      }
    }
    return result;
  }
}
// @lc code=end
