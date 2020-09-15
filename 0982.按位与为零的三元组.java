/*
 * @lc app=leetcode.cn id=982 lang=java
 *
 * [982] 按位与为零的三元组
 */

// @lc code=start
class Solution {
  public int countTriplets(int[] A) {
    int n = 1 << 16;
    int[] dp = new int[n];
    dp[n - 1] = 1;
    for (int i = 0; i < 3; i++) {
      int[] buffer = new int[n];
      for (int j = 0; j < n; j++)
        for (int a : A)
          buffer[a & j] += dp[j];
      dp = buffer;
    }
    return dp[0];
  }
}
// @lc code=end
