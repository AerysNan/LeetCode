/*
 * @lc app=leetcode.cn id=991 lang=java
 *
 * [991] 坏了的计算器
 */

// @lc code=start
class Solution {
    public int brokenCalc(int X, int Y) {
        int result = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            result++;
        }

        return result + X - Y;
    }
}
// @lc code=end
