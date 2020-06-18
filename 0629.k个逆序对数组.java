/*
 * @lc app=leetcode.cn id=629 lang=java
 *
 * [629] K个逆序对数组
 */

// @lc code=start
class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i * (i - 1) / 2; j++) {
                int value = (dp[i - 1][j] - ((j - i) >= 0 ? dp[i - 1][j - i] : 0) + M) % M;
                dp[i][j] = (dp[i][j - 1] + value) % M;
            }
        }
        return dp[n][k];
    }
}
// @lc code=end
