/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */
class Solution {
  public int longestArithSeqLength(int[] A) {
    int n = A.length;
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int value : A) {
      max = Math.max(max, value);
      min = Math.min(min, value);
    }
    int m = 2 * (max - min) + 1;
    int[] cnt = new int[m];
    int[][] dp = new int[n][m];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int diff = A[i] - A[j];
        int k = diff + max - min;
        dp[i][k] = Math.max(dp[i][k], dp[j][k] + 1);
        cnt[k] = Math.max(cnt[k], dp[i][k]);
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++)
      result = Math.max(result, cnt[i]);
    return result + 1;
  }
}
