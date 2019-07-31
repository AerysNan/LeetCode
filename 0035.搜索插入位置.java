import java.util.Collections;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */
class Solution {
  public int searchInsert(int[] nums, int target) {
    return search(nums, 0, nums.length - 1, target);
  }

  int search(int[] nums, int l, int h, int target) {
    if (l > h)
      return l;
    int mid = (l + h) / 2;
    if (nums[mid] == target)
      return mid;
    if (nums[mid] > target)
      return search(nums, l, mid - 1, target);
    return search(nums, mid + 1, h, target);
  }
}
