/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
  public String reorderSpaces(String text) {
    String[] words = text.trim().split("\\s+");
    int count = 0;
    for (char c : text.toCharArray())
      if (c == ' ')
        count++;
    StringBuilder result = new StringBuilder();
    if (words.length == 1) {
      result.append(words[0]);
      for (int i = 0; i < count; i++)
        result.append(' ');
      return result.toString();
    }
    int each = count / (words.length - 1);
    result.append(words[0]);
    for (int j = 1; j < words.length; j++) {
      for (int i = 0; i < each; i++)
        result.append(' ');
      result.append(words[j]);
    }
    int remain = count - each * (words.length - 1);
    for (int i = 0; i < remain; i++)
      result.append(' ');
    return result.toString();

  }
}
// @lc code=end
