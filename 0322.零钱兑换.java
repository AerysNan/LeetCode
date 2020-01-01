/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int coinChange(int[] coins, int amount) {
    long[] dp = new long[amount + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      if (dp[i] == -1)
        continue;
      for (int coin : coins)
        if ((long) i + (long) coin <= amount)
          dp[i + coin] = dp[i + coin] == -1 ? (dp[i] + 1) : Math.min(dp[i + coin], dp[i] + 1);
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
  }
}
// @lc code=end

