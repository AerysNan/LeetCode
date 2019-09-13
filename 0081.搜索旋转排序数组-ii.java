/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
  public boolean search(int[] nums, int target) {
    int n = nums.length;
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target)
        return true;
      if (nums[mid] < nums[r] || nums[mid] < nums[l]) {
        if (target > nums[mid] && target <= nums[r])
          l = mid + 1;
        else
          r = mid - 1;
      } else if (nums[mid] > nums[l] || nums[mid] > nums[r]) {
        if (target < nums[mid] && target >= nums[l])
          r = mid - 1;
        else
          l = mid + 1;
      } else
        r--;
    }
    return false;
  }
}
// @lc code=end

