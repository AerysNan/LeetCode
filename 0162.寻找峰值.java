/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
  public int findPeakElement(int[] nums) {
    return peek(nums, 0, nums.length - 1);
  }

  int peek(int[] nums, int l, int r) {
    int n = nums.length, mid = (l + r) / 2;
    if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))
      return mid;
    if (mid == n - 1 || nums[mid] > nums[mid + 1])
      return peek(nums, l, mid - 1);
    return peek(nums, mid + 1, r);
  }
}
// @lc code=end

