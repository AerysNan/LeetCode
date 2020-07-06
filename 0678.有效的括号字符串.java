/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            l += c == '(' ? 1 : -1;
            r += c != ')' ? 1 : -1;
            if (r < 0)
                break;
            l = Math.max(l, 0);
        }
        return l == 0;
    }
}
// @lc code=end
