/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 灯泡开关 III
 */

// @lc code=start
class Solution {
  public int numTimesAllBlue(int[] light) {
    int result = 0, index = 0, max = Integer.MIN_VALUE;
    boolean[] status = new boolean[light.length];
    for (int l : light) {
      status[l - 1] = true;
      max = Math.max(max, l - 1);
      while (index < light.length && status[index])
        index++;
      if (index > max)
        result++;
    }
    return result;
  }
}
// @lc code=end

