/*
 * @lc app=leetcode.cn id=1595 lang=java
 *
 * [1595] 连通两组点的最小成本
 */

// @lc code=start
import java.util.List;

class Solution {
  public int connectTwoGroups(List<List<Integer>> cost) {
    int m = cost.size(), n = cost.get(0).size();
    int[][] costMatrix = new int[m][1 << n];
    for (int k = 0; k < m; k++) {
      for (int i = 0; i < (1 << n); i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
          if ((i & (1 << j)) > 0)
            sum += cost.get(k).get(j);
        }
        costMatrix[k][i] = sum;
      }
    }
    int[][] dp = new int[m][1 << n];
    for (int i = 1; i < m; i++)
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    dp[0] = costMatrix[0];
    for (int i = 1; i < m; i++) {
      for (int k = 1; k < (1 << n); k++) {
        if (dp[i - 1][k] == Integer.MAX_VALUE)
          continue;
        for (int j = 0; j < n; j++)
          dp[i][k | (1 << j)] = Math.min(dp[i][k | (1 << j)], dp[i - 1][k] + cost.get(i).get(j));
        int rest = (1 << n) - 1 - k;
        for (int j = rest; j >= 1; j = rest & (j - 1)) {
          dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][k] + costMatrix[i][j]);
        }
      }
    }
    return dp[m - 1][(1 << n) - 1];
  }
}

// @lc code=end
