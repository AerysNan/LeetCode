/*
 * @lc app=leetcode.cn id=483 lang=java
 *
 * [483] 最小好进制
 */

// @lc code=start
class Solution {
    public String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        for (int m = 59; m > 1; m--) {
            long k = (long) Math.pow(N, 1.0 / m);
            if (k <= 1)
                continue;
            long s = 0;
            for (int i = 0; i <= m; i++)
                s = s * k + 1;
            if (s == N)
                return String.valueOf(k);
        }
        return String.valueOf(N - 1);
    }
}
// @lc code=end
