/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int minMoves2(int[] nums) {
    int median = find(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    return Arrays.stream(nums).map(x -> Math.abs(x - median)).reduce(0, (x, y) -> x + y);
  }

  int find(int[] nums, int l, int r, int k) {
    if (l == r && k == 1)
      return nums[l];
    int pivot = nums[l], i = l, j = r;
    while (i < j) {
      while (i < j && nums[j] >= pivot)
        j--;
      nums[i] = nums[j];
      while (i < j && nums[i] <= pivot)
        i++;
      nums[j] = nums[i];
    }
    nums[i] = pivot;
    if (i - l + 1 == k)
      return pivot;
    if (i - l + 1 < k)
      return find(nums, i + 1, r, k - i + l - 1);
    return find(nums, l, i - 1, k);
  }
}
// @lc code=end

