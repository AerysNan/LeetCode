/*
 * @lc app=leetcode.cn id=1190 lang=java
 *
 * [1190] 反转每对括号间的子串
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public String reverseParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    char[] array = s.toCharArray();
    int n = array.length;
    for (int i = 0; i < n; i++) {
      if (array[i] == '(')
        stack.push(i);
      else if (array[i] == ')')
        reverse(array, stack.pop(), i);
    }
    StringBuilder result = new StringBuilder();
    for (char c : array)
      if (c != '(' && c != ')')
        result.append(c);
    return result.toString();
  }

  void reverse(char[] array, int l, int r) {
    int n = (r - l + 1) / 2;
    for (int i = 0; i < n; i++) {
      char c = array[l + i];
      array[l + i] = array[r - i];
      array[r - i] = c;
    }
  }
}
// @lc code=end

