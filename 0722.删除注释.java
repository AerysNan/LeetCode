/*
 * @lc app=leetcode.cn id=722 lang=java
 *
 * [722] 删除注释
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock)
                newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/')
                    break;
                else if (!inBlock)
                    newline.append(chars[i]);
                i++;
            }
            if (!inBlock && newline.length() > 0)
                result.add(newline.toString());
        }
        return result;
    }
}
// @lc code=end
