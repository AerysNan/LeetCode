/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return false;
    int m = matrix.length, n = matrix[0].length;
    int l = 0, r = m - 1;
    while (l < r) {
      int mid = (l + r + 1) / 2;
      if (matrix[mid][0] == target)
        return true;
      if (matrix[mid][0] < target)
        l = mid;
      else
        r = mid - 1;
    }
    int index = l;
    l = 0;
    r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (matrix[index][mid] == target)
        return true;
      if (matrix[index][mid] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }
    return false;
  }
}
// @lc code=end
