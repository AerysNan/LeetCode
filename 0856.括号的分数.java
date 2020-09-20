/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public int scoreOfParentheses(String S) {
    Stack<Integer> s = new Stack<>();
    for (char c : S.toCharArray()) {
      if (c == '(')
        s.push(-1);
      else {
        int sum = 0;
        while (s.peek() != -1)
          sum += s.pop();
        s.pop();
        s.push(sum == 0 ? 1 : 2 * sum);
      }
    }
    int result = 0;
    while (!s.isEmpty())
      result += s.pop();
    return result;
  }
}
// @lc code=end
