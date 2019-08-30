/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
  public boolean isNumber(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'a' && c <= 'z' && c != 'e' || c >= 'A' && c <= 'Z' && c != 'E')
        return false;
    }
    try {
      Double.parseDouble(s);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
// @lc code=end
