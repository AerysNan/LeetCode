import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
  public int maxProduct(String[] words) {
    int result = 0, n = words.length;
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return Integer.compare(s2.length(), s1.length());
      }
    });
    int[] masks = new int[n];
    for (int i = 0; i < n; i++)
      for (char c : words[i].toCharArray())
        masks[i] |= 1 << (c - 'a');
    for (int i = 0; i < n - 1; i++) {
      if (words[i].length() * words[i].length() <= result)
        break;
      for (int j = i + 1; j < n; j++) {
        if ((masks[i] & masks[j]) == 0) {
          result = Math.max(result, words[i].length() * words[j].length());
          break;
        }
      }
    }
    return result;
  }
}
// @lc code=end

