/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */
class Solution {
  public int lastStoneWeightII(int[] stones) {
    int n = stones.length, sum = 0;
    for (int stone : stones)
      sum += stone;
    int m = sum / 2;
    int[] dp = new int[m + 1];
    for (int i = 0; i < n; i++)
      for (int j = m; j >= stones[i]; j--)
        dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
    return sum - 2 * dp[m];
  }
}
