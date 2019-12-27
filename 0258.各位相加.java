/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
  public int addDigits(int num) {
    return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
  }
}
// @lc code=end

