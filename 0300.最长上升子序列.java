/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length <= 1)
      return nums.length;
    int n = nums.length, result = 0;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++)
        if (nums[i] > nums[j])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      result = Math.max(result, dp[i]);
    }
    return result;
  }
}
// @lc code=end

