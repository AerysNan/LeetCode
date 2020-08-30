/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 */

// @lc code=start
class Solution {
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    return count(A, R) - count(A, L - 1);
  }

  int count(int[] A, int bound) {
    int result = 0, current = 0;
    for (int a : A) {
      current = a <= bound ? current + 1 : 0;
      result += current;
    }
    return result;
  }
}
// @lc code=end
