/*
 * @lc app=leetcode.cn id=1344 lang=java
 *
 * [1344] 时钟指针的夹角
 */

// @lc code=start
class Solution {
  public double angleClock(int hour, int minutes) {
    double m = 6 * minutes, h = 30 * hour + 0.5 * minutes;
    double result = Math.abs(m - h);
    return result > 180 ? 360 - result : result;
  }
}
// @lc code=end

