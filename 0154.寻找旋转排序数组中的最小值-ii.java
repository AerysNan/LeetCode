/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
  public int findMin(int[] nums) {
    int n = nums.length, l = 0, r = n - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] < nums[r])
        r = mid;
      else if (nums[mid] > nums[r])
        l = mid + 1;
      else
        r--;
    }
    return nums[l];
  }
}
// @lc code=end

