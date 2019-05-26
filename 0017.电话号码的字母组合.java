import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */
class Solution {
  private char[][] map = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
      { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
  private List<String> result;

  public List<String> letterCombinations(String digits) {
    result = new ArrayList<>();
    if (digits == null || digits.length() == 0)
      return result;
    build(digits, 0, new StringBuilder());
    return result;
  }

  private void build(String digits, int index, StringBuilder sb) {
    if (index == digits.length()) {
      result.add(sb.toString());
      return;
    }
    for (char c : map[digits.charAt(index) - '0' - 2]) {
      sb.append(c);
      build(digits, index + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
