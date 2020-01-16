/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int result = 0, l = 0, r = 0;
    for (int time : timeSeries) {
      if (r < time) {
        result += r - l;
        l = time;
      }
      r = time + duration;
    }
    result += r - l;
    return result;
  }
}
// @lc code=end

