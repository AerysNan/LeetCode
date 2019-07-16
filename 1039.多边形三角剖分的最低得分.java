/*
 * @lc app=leetcode.cn id=1039 lang=java
 *
 * [1039] 多边形三角剖分的最低得分
 */
class Solution {
  int[][] dp;

  public int minScoreTriangulation(int[] A) {
    int N = A.length;
    dp = new int[N][N];
    return solve(0, A.length - 1, A);
  }

  int solve(int l, int h, int[] A) {
    if (h - l < 2)
      return 0;
    if (dp[l][h] > 0)
      return dp[l][h];
    int value = Integer.MAX_VALUE;
    for (int i = l + 1; i < h; i++)
      value = Math.min(value, solve(l, i, A) + solve(i, h, A) + A[l] * A[h] * A[i]);
    dp[l][h] = value;
    return value;
  }
}
