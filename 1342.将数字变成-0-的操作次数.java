/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class Solution {
  public int numberOfSteps(int num) {
    int result = 0;
    while (num != 0) {
      result += (num == 1 || (num & 1) == 0) ? 1 : 2;
      num >>= 1;
    }
    return result;
  }
}
// @lc code=end

