/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
  public void sortColors(int[] nums) {
    int index0 = 0, index2 = nums.length - 1, index = 0;
    while (index <= index2) {
      if (nums[index] == 0) {
        nums[index] = nums[index0];
        nums[index0] = 0;
        index0++;
      }
      if (nums[index] == 2) {
        nums[index] = nums[index2];
        nums[index2] = 2;
        index2--;
        index--;
      }
      index++;
    }
  }
}
// @lc code=end
