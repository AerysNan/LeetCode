import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1335 lang=java
 *
 * [1335] 工作计划的最低难度
 */

// @lc code=start
class Solution {
  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d)
      return -1;
    int[][] dp = new int[d][n];
    int max = -1;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, jobDifficulty[i]);
      dp[0][i] = max;
    }
    for (int i = 1; i < d; i++)
      for (int j = 0; j < n; j++)
        dp[i][j] = Integer.MAX_VALUE;
    for (int i = 1; i < d; i++) {
      for (int j = i; j < n; j++) {
        max = -1;
        for (int k = j - 1; k >= i - 1; k--) {
          max = Math.max(max, jobDifficulty[k + 1]);
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + max);
        }
      }
    }
    return dp[d - 1][n - 1];
  }
}
// @lc code=end

