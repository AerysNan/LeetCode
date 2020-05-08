/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return search(s.toCharArray(), 0, n - 1, new Integer[n][n]);
    }

    int search(char[] s, int l, int r, Integer[][] dp) {
        if (l == r)
            return 1;
        if (dp[l][r] != null)
            return dp[l][r];
        if (l + 1 == r && s[l] == s[r]) {
            dp[l][r] = 2;
            return 2;
        }
        int value = 1;
        value = Math.max(value, search(s, l + 1, r, dp));
        value = Math.max(value, search(s, l, r - 1, dp));
        if (s[l] == s[r])
            value = Math.max(value, search(s, l + 1, r - 1, dp) + 2);
        dp[l][r] = value;
        return value;
    }
}
// @lc code=end
