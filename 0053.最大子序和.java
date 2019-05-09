/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
  public int maxSubArray(int[] nums) {
    int result = Integer.MIN_VALUE;
    int n = nums.length;
    if (n == 0)
      return 0;
    for (int i = 0; i < n; i++)
      result = Math.max(result, nums[i]);
    if (result < 0)
      return result;
    int sum = 0;
    result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      sum = Math.max(sum, 0);
      sum += nums[i];
      result = Math.max(result, sum);
    }
    return result;
  }
}
