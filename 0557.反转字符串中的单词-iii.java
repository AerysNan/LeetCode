/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split(" "))
            result.append(new StringBuilder(word).reverse().toString()).append(' ');
        return result.substring(0, result.length() - 1).toString();
    }
}
// @lc code=end
