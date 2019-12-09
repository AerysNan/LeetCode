/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int pick = 0, skip = 0;
    for (int i = 0; i < nums.length; i++) {
      int value = skip + nums[i];
      skip = Math.max(skip, pick);
      pick = value;
    }
    return Math.max(pick, skip);
  }
}
// @lc code=end

