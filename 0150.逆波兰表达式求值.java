/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public int evalRPN(String[] tokens) {
    LinkedList<Integer> stack = new LinkedList<>();
    for (String s : tokens) {
      if (s.equals("+"))
        stack.addLast(stack.pollLast() + stack.pollLast());
      else if (s.equals("-"))
        stack.addLast(-stack.pollLast() + stack.pollLast());
      else if (s.equals("*"))
        stack.addLast(stack.pollLast() * stack.pollLast());
      else if (s.equals("/")) {
        int value = stack.pollLast();
        stack.addLast(stack.pollLast() / value);
      } else
        stack.addLast(Integer.valueOf(s));
    }
    return stack.pollLast();
  }
}
// @lc code=end

