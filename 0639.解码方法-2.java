/*
 * @lc app=leetcode.cn id=639 lang=java
 *
 * [639] 解码方法 2
 */

// @lc code=start
class Solution {
    int M = 1000000007;

    public int numDecodings(String s) {
        Long[] memo = new Long[s.length()];
        return (int) ways(s, s.length() - 1, memo);
    }

    public long ways(String s, int i, Long[] memo) {
        if (i < 0)
            return 1;
        if (memo[i] != null)
            return memo[i];
        if (s.charAt(i) == '*') {
            long result = 9 * ways(s, i - 1, memo);
            if (i > 0 && s.charAt(i - 1) == '1')
                result = (result + 9 * ways(s, i - 2, memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '2')
                result = (result + 6 * ways(s, i - 2, memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '*')
                result = (result + 15 * ways(s, i - 2, memo)) % M;
            memo[i] = result;
            return memo[i];
        }
        long result = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
        if (i > 0 && s.charAt(i - 1) == '1')
            result = (result + ways(s, i - 2, memo)) % M;
        else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
            result = (result + ways(s, i - 2, memo)) % M;
        else if (i > 0 && s.charAt(i - 1) == '*')
            result = (result + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i - 2, memo)) % M;
        memo[i] = result;
        return memo[i];
    }
}
// @lc code=end
