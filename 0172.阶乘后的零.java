/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
  public int trailingZeroes(int n) {
    int count5 = 0, value5 = n;
    while (value5 != 0) {
      value5 /= 5;
      count5 += value5;
    }
    return count5;
  }
}
// @lc code=end

