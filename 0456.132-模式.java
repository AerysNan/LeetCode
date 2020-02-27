/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132模式
 */

// @lc code=start
import java.util.Stack;

class Solution {
  public boolean find132pattern(int[] nums) {
    Stack<Integer> monoStack = new Stack<>();
    int second = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < second)
        return true;
      while (!monoStack.isEmpty() && monoStack.peek() < nums[i])
        second = monoStack.pop();
      monoStack.push(nums[i]);
    }
    return false;
  }
}
// @lc code=end

