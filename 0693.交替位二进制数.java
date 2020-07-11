/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = 1 - (n & 1);
        while (n != 0) {
            int mod = n & 1;
            if (prev == mod)
                return false;
            prev = mod;
            n /= 2;

        }
        return true;
    }
}
// @lc code=end
