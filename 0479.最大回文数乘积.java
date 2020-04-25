/*
 * @lc app=leetcode.cn id=479 lang=java
 *
 * [479] 最大回文数乘积
 */

// @lc code=start
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;
        long max = (long) Math.pow(10, n) - 1;
        for (long i = max - 1; i > max / 10; i--) {
            String s1 = String.valueOf(i);
            long concat = Long.parseLong(s1 + new StringBuilder(s1).reverse().toString());
            for (long x = max; x * x >= concat; x--)
                if (concat % x == 0)
                    return (int) (concat % 1337);
        }
        return -1;
    }
}
// @lc code=end
