/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++)
            result = Math.max(result, prefix[i + k] - prefix[i]);
        return (double) result / k;
    }
}
// @lc code=end
