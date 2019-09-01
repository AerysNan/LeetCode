/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
  public int mySqrt(int x) {
    long r = x;
    while (r * r > x)
      r = (r + x / r) / 2;
    return (int) r;
  }
}
// @lc code=end
