/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
  public int maxDistToClosest(int[] seats) {
    int prev = -1, result = 1;
    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == 0)
        continue;
      if (prev >= 0)
        result = Math.max((i - prev) / 2, result);
      else
        result = i;
      prev = i;
    }
    result = Math.max((seats.length - 1) - prev, result);
    return result;
  }
}
// @lc code=end
