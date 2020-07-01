/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length, result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = A[i] == B[j] ? dp[i][j] + 1 : 0;
                result = Math.max(result, dp[i + 1][j + 1]);
            }
        }
        return result;
    }
}
// @lc code=end
