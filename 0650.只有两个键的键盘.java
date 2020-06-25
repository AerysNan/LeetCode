/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        int result = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                result += d;
                n /= d;
            }
            d++;
        }
        return result;
    }
}
// @lc code=end
