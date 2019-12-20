/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int n = nums.length, l = 0, r = 0, sum = 0, result = Integer.MAX_VALUE;
    while (l < n) {
      if (r < n && sum < s)
        sum += nums[r++];
      else
        sum -= nums[l++];
      if (sum >= s)
        result = Math.min(result, r - l);
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
// @lc code=end

