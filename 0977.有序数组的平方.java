/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
  public int[] sortedSquares(int[] A) {
    int index = 0, n = A.length;
    for (int i = 0; i < n; i++) {
      if (Math.abs(A[index]) > Math.abs(A[i]))
        index = i;
    }
    int[] result = new int[n];
    int current = 0, l = index - 1, r = index + 1;
    result[current++] = A[index] * A[index];
    while (l >= 0 && r < n) {
      if (Math.abs(A[l]) < Math.abs(A[r]))
        result[current++] = A[l] * A[l--];
      else
        result[current++] = A[r] * A[r++];
    }
    while (l >= 0)
      result[current++] = A[l] * A[l--];
    while (r < n)
      result[current++] = A[r] * A[r++];
    return result;
  }
}
// @lc code=end
