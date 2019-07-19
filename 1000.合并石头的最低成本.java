/*
 * @lc app=leetcode.cn id=1000 lang=java
 *
 * [1000] 合并石头的最低成本
 */
class Solution {
  public int mergeStones(int[] stones, int K) {
    int n = stones.length;
    if ((n - 1) % (K - 1) != 0)
      return -1;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++)
      prefix[i + 1] = prefix[i] + stones[i];
    int[][] dp = new int[n][n];
    for (int len = K; len <= n; len++) {
      for (int i = 0; i + len <= n; i++) {
        int j = i + len - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k += K - 1)
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
        if ((len - 1) % (K - 1) == 0)
          dp[i][j] += prefix[j + 1] - prefix[i];
      }
    }
    return dp[0][n - 1];
  }
}
