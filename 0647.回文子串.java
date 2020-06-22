/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.equals(""))
            return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = s.length();
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? (j - i == 1 ? true : dp[i + 1][j - 1]) : false;
                if (dp[i][j])
                    result++;
            }
        }
        return result;

    }
}
// @lc code=end
