/*
 * @lc app=leetcode.cn id=689 lang=java
 *
 * [689] 三个无重叠子数组的最大和
 *
 * https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (39.09%)
 * Total Accepted:    180
 * Total Submissions: 449
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 *
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 *
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
 *
 * 示例:
 *
 *
 * 输入: [1,2,1,2,6,7,5,1], 2
 * 输出: [0, 3, 5]
 * 解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
 * 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 *
 *
 * 注意:
 *
 *
 * nums.length的范围在[1, 20000]之间。
 * nums[i]的范围在[1, 65535]之间。
 * k的范围在[1, floor(nums.length / 3)]之间。
 *
 *
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
