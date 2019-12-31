/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
  public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] values = new int[n + 2];
    System.arraycopy(nums, 0, values, 1, n);
    values[0] = 1;
    values[n + 1] = 1;
    return search(values, 0, n + 1, new int[n + 2][n + 2]);
  }

  int search(int[] values, int l, int r, int[][] dp) {
    if (l + 1 == r)
      return 0;
    if (dp[l][r] > 0)
      return dp[l][r];
    int result = 0;
    for (int i = l + 1; i < r; i++)
      result = Math.max(result,
          values[l] * values[r] * values[i] + search(values, l, i, dp) + search(values, i, r, dp));
    dp[l][r] = result;
    return result;
  }
}
// @lc code=end

