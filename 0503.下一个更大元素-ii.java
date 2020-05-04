/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0)
            return new int[] {};
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                result[stack.pop()] = nums[i];
            stack.push(i);
        }
        for (int i = 0; i < n; i++)
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                result[stack.pop()] = nums[i];
        while (!stack.isEmpty())
            result[stack.pop()] = -1;
        return result;
    }
}
// @lc code=end
