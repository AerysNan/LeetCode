import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
  public int findTargetSumWays(int[] nums, int S) {
    int sum = Arrays.stream(nums).reduce(0, (x, y) -> x + y);
    if (sum < S || (sum + S) % 2 == 1)
      return 0;
    int w = (sum + S) / 2;
    int[] dp = new int[w + 1];
    dp[0] = 1;
    for (int num : nums)
      for (int i = w; i >= num; i--)
        dp[i] += dp[i - num];
    return dp[w];
  }
}
// @lc code=end

