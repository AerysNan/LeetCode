/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int result = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); result++)
            S.append(A);
        if (S.indexOf(B) >= 0)
            return result;
        if (S.append(A).indexOf(B) >= 0)
            return result + 1;
        return -1;
    }
}
// @lc code=end
