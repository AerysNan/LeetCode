import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.55%)
 * Total Accepted:    7K
 * Total Submissions: 27.6K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 *
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
