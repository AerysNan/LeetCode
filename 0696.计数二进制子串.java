/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0, n = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1])
                continue;
            result++;
            int offset = 1;
            while (i - offset >= 0 && i + 1 + offset < n && array[i - offset] == array[i]
                    && array[i + 1 + offset] == array[i + 1]) {
                offset++;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end
