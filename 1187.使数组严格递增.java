/*
 * @lc app=leetcode.cn id=1187 lang=java
 *
 * [1187] 使数组严格递增
 */

// @lc code=start
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    TreeSet<Integer> set = new TreeSet<>(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    int n = arr1.length;
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= n; j++)
        dp[i][j] = Integer.MAX_VALUE;
    dp[0][0] = -1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        if (arr1[i - 1] > dp[j][i - 1])
          dp[j][i] = arr1[i - 1];
        if (j > 0) {
          Integer replace = set.higher(dp[j - 1][i - 1]);
          if (replace != null)
            dp[j][i] = Math.min(dp[j][i], replace);
        }
        if (i == n && dp[j][i] != Integer.MAX_VALUE)
          return j;
      }
    }
    return -1;
  }
}
// @lc code=end

