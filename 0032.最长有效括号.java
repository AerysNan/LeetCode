import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */
class Solution {
  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(')
        stack.push(i);
      else {
        if (stack.peek() == -1 || s.charAt(stack.peek()) == ')')
          stack.push(i);
        else
          stack.pop();
      }
    }
    if (stack.isEmpty())
      return n;
    int result = n - stack.peek() - 1;
    while (stack.size() > 1) {
      int end = stack.pop();
      result = Math.max(result, end - 1 - stack.peek());
    }
    return result;
  }
}
