import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */
class Solution {
  public String removeOuterParentheses(String S) {
    ArrayList<String> list = new ArrayList<>();
    String current = "";
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      current += c;
      if (c == '(')
        stack.addLast(c);
      else if (c == ')') {
        stack.pollLast();
        if (stack.isEmpty()) {
          list.add(current.substring(1, current.length() - 1));
          current = "";
        }
      }
    }
    String result = "";
    for (String s : list)
      result += s;
    return result;
  }
}
