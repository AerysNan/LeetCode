/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        d.sort((s1, s2) -> {
            if (s1.length() != s2.length())
                return s2.length() - s1.length();
            return s1.compareTo(s2);
        });
        for (String word : d)
            if (match(s, word))
                return word;
        return "";
    }

    boolean match(String base, String word) {
        if (word.length() > base.length())
            return false;
        int n = base.length(), m = word.length(), i = 0, j = 0;
        while (i < n && j < m)
            if (base.charAt(i++) == word.charAt(j))
                j++;
        return j == m;
    }
}
// @lc code=end
