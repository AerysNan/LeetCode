/*
 * @lc app=leetcode.cn id=775 lang=java
 *
 * [775] 全局倒置与局部倒置
 */

// @lc code=start
class Solution {
  public boolean isIdealPermutation(int[] A) {
    int n = A.length, min = n;
    for (int i = n - 1; i >= 2; --i) {
      min = Math.min(min, A[i]);
      if (A[i - 2] > min)
        return false;
    }
    return true;

  }
}
// @lc code=end

