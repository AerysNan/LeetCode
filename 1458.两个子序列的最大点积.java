/*
 * @lc app=leetcode.cn id=1458 lang=java
 *
 * [1458] 两个子序列的最大点积
 */

// @lc code=start
class Solution {
  public int maxDotProduct(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++)
      dp[i][0] = Integer.MIN_VALUE;
    for (int i = 0; i <= n; i++)
      dp[0][i] = Integer.MIN_VALUE;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.max(dp[i - 1][j - 1], 0) + nums1[i - 1] * nums2[j - 1];
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
      }
    }
    return dp[m][n];
  }
}
// @lc code=end

