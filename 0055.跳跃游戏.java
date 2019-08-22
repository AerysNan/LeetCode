/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
  public boolean canJump(int[] nums) {
    int farthest = 0, n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      if (i == farthest && nums[i] == 0)
        return false;
      farthest = Math.max(farthest, i + nums[i]);
    }
    return true;
  }
}
// @lc code=end
