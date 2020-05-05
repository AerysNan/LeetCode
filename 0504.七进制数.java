/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        boolean negative = num < 0;
        num = Math.abs(num);
        while (num > 0) {
            result.append(num % 7);
            num /= 7;
        }
        if (negative)
            result.append("-");
        return result.reverse().toString();
    }
}
// @lc code=end
