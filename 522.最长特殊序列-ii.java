/*
 * @lc app=leetcode.cn id=522 lang=java
 *
 * [522] 最长特殊序列 II
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public boolean isSubsequence(String x, String y) {
        int i = 0, j = 0;
        while (i < x.length() && j < y.length()) 
            if (x.charAt(i) == y.charAt(j++))
                i++;
        return i == x.length();
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return strs[i].length();
        }
        return -1;
    }
}
// @lc code=end
