/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    return backtrack(nums, target, dp, 0);
  }

  private int backtrack(int[] nums, int target, int[] dp, int sum) {
    if (sum > target)
      return 0;
    if (sum == target)
      return 1;
    if (dp[sum] != -1)
      return dp[sum];
    int count = 0;
    for (int num : nums)
      count += backtrack(nums, target, dp, sum + num);
    dp[sum] = count;
    return count;
  }
}
// @lc code=end

