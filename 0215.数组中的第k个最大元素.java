/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
  public int findKthLargest(int[] nums, int k) {
    int n = nums.length, pivot = nums[0], l = 0, r = n - 1;
    if (n == 1)
      return pivot;
    return find(nums, k, l, r);
  }

  int find(int[] nums, int k, int l, int r) {
    int pivot = nums[l];
    int _l = l, _r = r;
    while (_l < _r) {
      while (_l < _r && nums[_r] > pivot)
        _r--;
      nums[_l] = nums[_r];
      while (_l < _r && nums[_l] <= pivot)
        _l++;
      nums[_r] = nums[_l];
    }
    nums[_r] = pivot;
    int rank = r - _r + 1;
    if (rank == k)
      return nums[_r];
    if (rank > k)
      return find(nums, k, _r + 1, r);
    return find(nums, k - rank, l, _r - 1);
  }
}
// @lc code=end

