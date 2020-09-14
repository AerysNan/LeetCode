/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */

// @lc code=start
class Solution {
  public int maxTurbulenceSize(int[] A) {
    int n = A.length, prev = 0, result = 1;
    for (int i = 1; i < n; i++) {
      int c = Integer.compare(A[i - 1], A[i]);
      if (i == n - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
        if (c != 0)
          result = Math.max(result, i - prev + 1);
        prev = i;
      }
    }
    return result;
  }
}

// @lc code=end
