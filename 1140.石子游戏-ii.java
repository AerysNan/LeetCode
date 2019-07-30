/*
 * @lc app=leetcode.cn id=1140 lang=java
 *
 * [1140] 石子游戏 II
 */
class Solution {
  int[] prefix;
  int[][] dp;

  public int stoneGameII(int[] piles) {
    int n = piles.length;
    dp = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        dp[i][j] = Integer.MIN_VALUE;
    prefix = new int[n + 1];
    for (int i = 0; i < n; i++)
      prefix[i + 1] = prefix[i] + piles[i];
    return (prefix[n] + solve(0, 1)) / 2;
  }

  int solve(int p, int c) {
    if (dp[p][c] != Integer.MIN_VALUE)
      return dp[p][c];
    int n = prefix.length - 1;
    if (p + 2 * c >= n)
      return prefix[n] - prefix[p];
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= 2 * c; i++)
      result = Math.max(result, prefix[i + p] - prefix[p] - solve(p + i, Math.max(i, c)));
    dp[p][c] = result;
    return result;
  }
}
