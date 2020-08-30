/*
 * @lc app=leetcode.cn id=801 lang=java
 *
 * [801] 使序列递增的最小交换次数
 */

// @lc code=start
class Solution {
  public int minSwap(int[] A, int[] B) {
    int skip = 0, swap = 1, n = A.length;
    for (int i = 1; i < n; i++) {
      int newSkip = Integer.MAX_VALUE, newSwap = Integer.MAX_VALUE;
      if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
        newSkip = Math.min(newSkip, skip);
        newSwap = Math.min(newSwap, swap + 1);
      }
      if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
        newSkip = Math.min(newSkip, swap);
        newSwap = Math.min(newSwap, skip + 1);
      }
      skip = newSkip;
      swap = newSwap;
    }
    return Math.min(skip, swap);
  }
}
// @lc code=end
