/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
  public int smallestRepunitDivByK(int K) {
    int value = 1, result = 1;
    boolean[] loop = new boolean[K];
    while (true) {
      value = value % K;
      if (value == 0)
        return result;
      if (loop[value])
        return -1;
      loop[value] = true;
      value = value * 10 + 1;
      result++;
    }
  }
}
// @lc code=end

