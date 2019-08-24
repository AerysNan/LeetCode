/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
  public int lengthOfLastWord(String s) {
    int index = s.length() - 1;
    while (index >= 0 && s.charAt(index) == ' ')
      index--;
    if (index < 0)
      return 0;
    int pos = index;
    while (pos >= 0 && s.charAt(pos) != ' ')
      pos--;
    return index - pos;
  }
}
// @lc code=end
