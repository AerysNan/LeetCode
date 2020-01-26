/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    if (A.length < 3)
      return 0;
    int result = 0;
    for (int i = 0; i < A.length - 2; i++) {
      for (int j = i + 2; j < A.length; j++) {
        if (A[j] - A[j - 1] == A[i + 1] - A[i])
          result++;
        else
          break;
      }
    }
    return result;
  }

}
// @lc code=end

