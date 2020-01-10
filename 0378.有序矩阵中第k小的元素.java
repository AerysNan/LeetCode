/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 */

// @lc code=start
class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int l = matrix[0][0], r = matrix[m - 1][n - 1];
    while (l < r) {
      int mid = (r - l) / 2 + l, count = 0, j = n - 1;
      for (int i = 0; i < m; i++) {
        while (j >= 0 && matrix[i][j] > mid)
          j--;
        count += j + 1;
      }
      if (count < k)
        l = mid + 1;
      else
        r = mid;
    }
    return l;
  }
}
// @lc code=end

