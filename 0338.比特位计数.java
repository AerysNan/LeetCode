/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; i++)
      result[i] = result[i >> 1] + (i & 1);
    return result;
  }
}
// @lc code=end

