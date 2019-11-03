/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
  public int findMin(int[] nums) {
    int n = nums.length, l = 0, r = n - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[r])
        l = mid + 1;
      else if (nums[mid] < nums[r])
        r = mid;
    }
    return nums[l];
  }
}
// @lc code=end

