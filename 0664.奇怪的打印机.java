/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 */
class Solution {
  private int[][] dp;

  private int search(int l, int h, String s) {
    if (dp[l][h] > 0)
      return dp[l][h];
    dp[l][h] = h - l + 1;
    for (int k = l; k < h; k++)
      dp[l][h] = Math.min(dp[l][h], search(l, k, s) + search(k + 1, h, s));
    if (s.charAt(l) == s.charAt(h))
      dp[l][h]--;
    return dp[l][h];
  }

  public int strangePrinter(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    dp = new int[n][n];
    for (int i = 0; i < n; i++)
      dp[i][i] = 1;
    return search(0, n - 1, s);
  }
}
