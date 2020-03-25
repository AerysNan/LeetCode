/*
 * @lc app=leetcode.cn id=1340 lang=java
 *
 * [1340] 跳跃游戏 V
 */

// @lc code=start
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
  int[] dp;

  public int maxJumps(int[] arr, int d) {
    int n = arr.length;
    dp = new int[n];
    int result = IntStream.range(0, n).map(x -> jump(arr, d, x)).max().getAsInt();
    return result;
  }

  int jump(int[] arr, int d, int pos) {
    if (dp[pos] > 0)
      return dp[pos];
    int n = arr.length;
    dp[pos] = 1;
    for (int i = 1; i <= d; i++) {
      if (pos + i < n && arr[pos + i] < arr[pos])
        dp[pos] = Math.max(dp[pos], jump(arr, d, pos + i) + 1);
      else
        break;
    }
    for (int i = 1; i <= d; i++) {
      if (pos - i >= 0 && arr[pos - i] < arr[pos])
        dp[pos] = Math.max(dp[pos], jump(arr, d, pos - i) + 1);
      else
        break;
    }
    return dp[pos];
  }
}
// @lc code=end

