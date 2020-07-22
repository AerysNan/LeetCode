/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String longestWord(String[] words) {
        HashSet<String> wordset = new HashSet<>();
        for (String word : words)
            wordset.add(word);
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String word : words) {
            boolean valid = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                return word;
        }
        return "";
    }
}
// @lc code=end
