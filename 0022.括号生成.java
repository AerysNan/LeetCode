import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (68.32%)
 * Total Accepted:    14.8K
 * Total Submissions: 21.6K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 *
 *
 */
class Solution {
  private Stack<Integer> stack;
  private StringBuilder builder;
  private ArrayList<String> result;

  public List<String> generateParenthesis(int n) {
    result = new ArrayList<>();
    stack = new Stack<>();
    builder = new StringBuilder();
    dfs(0, n);
    return result;
  }

  private void dfs(int i, int n) {
    if (i == n && stack.isEmpty()) {
      result.add(builder.toString());
      return;
    }
    if (i < n) {
      stack.push(1);
      builder.append('(');
      dfs(i + 1, n);
      builder.deleteCharAt(builder.length() - 1);
      stack.pop();
    }
    if (!stack.isEmpty()) {
      stack.pop();
      builder.append(')');
      dfs(i, n);
      builder.deleteCharAt(builder.length() - 1);
      stack.push(1);
    }
  }
}
