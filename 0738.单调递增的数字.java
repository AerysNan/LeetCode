/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i - 1] <= S[i])
            i++;
        while (i > 0 && i < S.length && S[i - 1] > S[i])
            S[--i]--;
        for (int j = i + 1; j < S.length; ++j)
            S[j] = '9';
        return Integer.parseInt(String.valueOf(S));
    }
}
// @lc code=end
