/*
 * @lc app=leetcode.cn id=818 lang=java
 *
 * [818] 赛车
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int racecar(int target) {
    int[] dp = new int[target + 3];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 4;

    for (int i = 3; i <= target; i++) {
      int k = 32 - Integer.numberOfLeadingZeros(i);
      if (i == (1 << k) - 1) {
        dp[i] = k;
        continue;
      }
      for (int j = 0; j < k - 1; j++)
        dp[i] = Math.min(dp[i], dp[i - (1 << (k - 1)) + (1 << j)] + k + j + 1);
      if ((1 << k) - 1 - i < i)
        dp[i] = Math.min(dp[i], dp[(1 << k) - 1 - i] + k + 1);
    }

    return dp[target];
  }
}
// @lc code=end
