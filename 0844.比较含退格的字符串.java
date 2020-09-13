import java.util.Stack;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
  public boolean backspaceCompare(String S, String T) {
    StringBuilder s = new StringBuilder();
    for (char c : S.toCharArray()) {
      if (c == '#') {
        if (s.length() > 0)
          s.deleteCharAt(s.length() - 1);
      } else
        s.append(c);
    }
    StringBuilder t = new StringBuilder();
    for (char c : T.toCharArray()) {
      if (c == '#') {
        if (t.length() > 0)
          t.deleteCharAt(t.length() - 1);
      } else
        t.append(c);
    }
    return s.toString().equals(t.toString());
  }
}
// @lc code=end
