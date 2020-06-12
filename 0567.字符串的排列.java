/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] map = new int[26];
        for (char c : s1.toCharArray())
            map[c - 'a']++;
        for (int i = 0; i <= n - m; i++) {
            int[] count = new int[26];
            for (char c : s2.substring(i, i + m).toCharArray())
                count[c - 'a']++;
            if (match(map, count))
                return true;
        }
        return false;
    }

    boolean match(int[] l1, int[] l2) {
        for (int i = 0; i < 26; i++)
            if (l1[i] != l2[i])
                return false;
        return true;
    }
}
// @lc code=end
