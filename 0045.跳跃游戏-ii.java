/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
  public int jump(int[] nums) {
    int result = 0, farthest = 0, pos = 0, n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);
      if (i == pos) {
        result++;
        pos = farthest;
      }
    }
    return result;
  }
}
// @lc code=end
