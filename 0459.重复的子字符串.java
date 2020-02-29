/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
  public boolean repeatedSubstringPattern(String s) {
    if (s == null || s.length() <= 1)
      return false;
    int length = s.length();
    for (int i = length / 2; i > 0; i--) {
      if (length % i != 0)
        continue;
      StringBuilder stringBuilder = new StringBuilder();
      int c = length / i;
      String string = s.substring(0, i);
      for (int j = 0; j < c; j++)
        stringBuilder.append(string);
      if (stringBuilder.toString().equals(s))
        return true;
    }
    return false;
  }
}
// @lc code=end

