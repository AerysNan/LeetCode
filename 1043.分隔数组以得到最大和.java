/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */
class Solution {
  public int maxSumAfterPartitioning(int[] A, int K) {
    int n = A.length;
    int[] dp = new int[n];
    int currentMax = -1;
    for (int i = 0; i < K; i++) {
      currentMax = Math.max(currentMax, A[i]);
      dp[i] = currentMax * (i + 1);
    }
    for (int i = K; i < n; i++) {
      currentMax = -1;
      for (int j = i - 1; j >= i - K; j--) {
        currentMax = Math.max(currentMax, A[j + 1]);
        dp[i] = Math.max(dp[i], dp[j] + currentMax * (i - j));
      }
    }
    return dp[n - 1];
  }
}
