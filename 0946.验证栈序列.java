/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int m = pushed.length, n = popped.length, index = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (s.isEmpty() || s.peek() != popped[i]) {
        if (index == m)
          return false;
        s.push(pushed[index++]);
      }
      s.pop();
    }
    return true;
  }
}
// @lc code=end
