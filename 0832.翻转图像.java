/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    int m = A.length, n = A[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = A[i][j];
        A[i][j] = A[i][n - 1 - j] ^ 1;
        A[i][n - 1 - j] = tmp ^ 1;
      }
      if (n % 2 == 1)
        A[i][n / 2] ^= 1;
    }
    return A;
  }
}
// @lc code=end
