/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */
class Solution {
  public int splitArray(int[] nums, int m) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int l = max, h = sum;
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (valid(mid, nums, m))
        h = mid - 1;
      else
        l = mid + 1;
    }
    return l;
  }

  private boolean valid(int target, int[] nums, int m) {
    int sum = 0, count = 1;
    for (int num : nums) {
      if (sum + num > target) {
        sum = num;
        count++;
      } else
        sum += num;
    }
    return count <= m;
  }
}
