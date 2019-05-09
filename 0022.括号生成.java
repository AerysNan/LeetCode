import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
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
