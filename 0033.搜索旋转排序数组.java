/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
  public int search(int[] nums, int target) {
    int n = nums.length;
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target)
        return mid;
      if (nums[mid] >= nums[l] && nums[mid] <= nums[r] && nums[mid] < target
          || nums[mid] < nums[l] && nums[mid] < target && nums[r] >= target
          || nums[mid] > nums[r] && (nums[mid] < target || nums[r] >= target))
        l = mid + 1;
      else
        r = mid - 1;
    }
    return -1;
  }
}
// @lc code=end
