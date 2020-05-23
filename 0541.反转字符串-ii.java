/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int j = Math.min(i + k - 1, n - 1);
            for (int l = 0; l < (j - i + 1) / 2; l++) {
                char c = array[i + l];
                array[i + l] = array[j - l];
                array[j - l] = c;
            }
        }
        return new String(array);
    }
}
// @lc code=end
