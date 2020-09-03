/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
  public double largestSumOfAverages(int[] A, int K) {
    int n = A.length;
    double[] sum = new double[n + 1];
    for (int i = 0; i < n; ++i)
      sum[i + 1] = sum[i] + A[i];
    double[] dp = new double[n];
    for (int i = 0; i < n; ++i)
      dp[i] = (sum[n] - sum[i]) / (n - i);
    for (int k = 0; k < K - 1; ++k)
      for (int i = 0; i < n; ++i)
        for (int j = i + 1; j < n; ++j)
          dp[i] = Math.max(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j]);
    return dp[0];
  }
}

// @lc code=end
