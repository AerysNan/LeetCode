/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public int findComplement(int num) {
    if (num == 0)
      return 1;
    Stack<Integer> s = new Stack<>();
    while (num > 0) {
      s.push(1 - (num & 1));
      num >>= 1;
    }
    int result = 0;
    while (!s.isEmpty())
      result = (result << 1) | s.pop();
    return result;
  }
}
// @lc code=end

