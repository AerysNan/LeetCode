/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
  public String reverseWords(String s) {
    int n = s.length();
    if (n == 0)
      return "";
    StringBuilder sb = new StringBuilder();
    int index = s.length() - 1;
    while (index >= 0) {
      if (s.charAt(index) == ' ') {
        index--;
        continue;
      }
      int start = index;
      while (start >= 0 && s.charAt(start) != ' ')
        start--;
      sb.append(' ');
      sb.append(s.substring(start + 1, index + 1));
      index = start;
    }
    if (sb.length() == 0)
      return "";
    return sb.substring(1);
  }
}
// @lc code=end

