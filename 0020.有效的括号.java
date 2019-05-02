import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
  public boolean isValid(String s) {
    LinkedList<Character> list = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
      case '(':
      case '[':
      case '{':
        list.addLast(c);
        break;
      case ')':
        if (list.isEmpty() || list.pollLast() != '(')
          return false;
        break;
      case ']':
        if (list.isEmpty() || list.pollLast() != '[')
          return false;
        break;
      case '}':
        if (list.isEmpty() || list.pollLast() != '{')
          return false;
        break;
      default:
        return false;
      }
    }
    return list.isEmpty();
  }
}
