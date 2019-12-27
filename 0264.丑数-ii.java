/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
  public int nthUglyNumber(int n) {
    int[] result = new int[n];
    result[0] = 1;
    int index2 = 0, index3 = 0, index5 = 0;
    int current2 = 2, current3 = 3, current5 = 5;
    for (int i = 1; i < n; i++) {
      int value = Math.min(current2, Math.min(current3, current5));
      result[i] = value;
      if (current2 == value)
        current2 = 2 * result[++index2];
      if (current3 == value)
        current3 = 3 * result[++index3];
      if (current5 == value)
        current5 = 5 * result[++index5];
    }
    return result[n - 1];
  }
}
// @lc code=end

