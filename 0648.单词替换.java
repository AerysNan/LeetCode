/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
import java.util.HashSet;
import java.util.List;

class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        HashSet<String> set = new HashSet<>();
        for (String root : roots)
            set.add(root);
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (set.contains(prefix))
                    break;
            }
            if (result.length() > 0)
                result.append(" ");
            result.append(prefix);
        }
        return result.toString();
    }
}
// @lc code=end
