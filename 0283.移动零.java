/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
  public void moveZeroes(int[] nums) {
    for (int i = 0, index = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != index) {
          nums[index] = nums[i];
          nums[i] = 0;
        }
        index++;
      }
    }
  }
}
// @lc code=end

