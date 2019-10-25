/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int volume = 0;
    for (int i = 0; i < gas.length; i++)
      volume += gas[i] - cost[i];
    if (volume < 0)
      return -1;
    int result = 0, acc = 0;
    for (int i = 0; i < gas.length; i++) {
      int d = gas[i] - cost[i];
      if (acc + d < 0) {
        result = i + 1;
        acc = 0;
      } else
        acc += d;
    }
    return result;
  }
}
// @lc code=end

