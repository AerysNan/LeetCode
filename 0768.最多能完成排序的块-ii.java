/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public int maxChunksToSorted(int[] arr) {
    Stack<Integer> s = new Stack<>();
    for (int value : arr) {
      if (s.isEmpty() || s.peek() <= value)
        s.push(value);
      else {
        int max = s.pop();
        while (!s.isEmpty() && s.peek() > value)
          s.pop();
        s.push(max);
      }
    }
    return s.size();
  }
}
// @lc code=end
