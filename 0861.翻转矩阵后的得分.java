/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 */

// @lc code=start
class Solution {
  public int matrixScore(int[][] A) {
    int m = A.length, n = A[0].length, result = 0;
    for (int j = 0; j < n; j++) {
      int sum = 0;
      for (int i = 0; i < m; i++)
        sum += A[i][j] ^ A[i][0];
      result += Math.max(sum, m - sum) * (1 << (n - 1 - j));
    }
    return result;
  }
}
// @lc code=end
