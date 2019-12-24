/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
  }

  int robRange(int[] nums, int l, int r) {
    int pick = 0, skip = 0;
    for (int i = l; i <= r; i++) {
      int value = skip + nums[i];
      skip = Math.max(pick, skip);
      pick = value;
    }
    return Math.max(pick, skip);
  }
}
// @lc code=end

