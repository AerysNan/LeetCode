/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
class Solution {
  public int numTilings(int N) {
    int mod = 1000000007;
    long[] dp = new long[N + 3];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;
    for (int i = 4; i <= N; i++)
      dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;
    return (int) dp[N];
  }
}
// @lc code=end
