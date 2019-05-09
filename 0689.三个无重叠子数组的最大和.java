/*
 * @lc app=leetcode.cn id=689 lang=java
 *
 * [689] 三个无重叠子数组的最大和
 */
class Solution {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length;
    int[] sum = new int[n + 1], lDP = new int[n + 1], rDP = new int[n + 1];
    for (int i = 1; i <= n; i++)
      sum[i] = sum[i - 1] + nums[i - 1];
    int maxL = Integer.MIN_VALUE;
    for (int i = k; i <= n; i++) {
      int value = sum[i] - sum[i - k];
      if (value > maxL) {
        maxL = value;
        lDP[i] = i - k;
      } else
        lDP[i] = lDP[i - 1];
    }
    int maxR = Integer.MIN_VALUE;
    for (int i = n - k; i >= 0; i--) {
      int value = sum[i + k] - sum[i];
      if (value >= maxR) {
        maxR = value;
        rDP[i] = i;
      } else
        rDP[i] = rDP[i + 1];
    }
    int maxG = Integer.MIN_VALUE;
    int[] result = new int[3];
    for (int i = k; i <= n - 2 * k; i++) {
      int value = sum[i + k] - sum[i] + sum[lDP[i] + k] - sum[lDP[i]] + sum[rDP[i + k] + k] - sum[rDP[i + k]];
      if (value > maxG) {
        maxG = value;
        result[0] = lDP[i];
        result[1] = i;
        result[2] = rDP[i + k];
      }
    }
    return result;
  }
}
