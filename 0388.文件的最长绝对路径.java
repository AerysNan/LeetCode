/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public int lengthLongestPath(String input) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int maxLength = 0;
    for (String s : input.split("\n")) {
      int level = s.lastIndexOf("\t") + 1;
      while (level + 1 < stack.size())
        stack.pop();
      int currentLength = stack.peek() + s.length() - level + 1;
      stack.push(currentLength);
      if (s.contains("."))
        maxLength = Math.max(maxLength, currentLength - 1);
    }
    return maxLength;
  }
}
// @lc code=end

