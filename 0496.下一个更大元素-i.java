/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    int[] less = new int[nums2.length];
    for (int i = 0; i < nums2.length; i++) {
      map.put(nums2[i], i);
      while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i])
        less[stack.pop()] = nums2[i];
      stack.push(i);
    }
    while (!stack.isEmpty())
      less[stack.pop()] = -1;
    return Arrays.stream(nums1).map(x -> less[map.get(x)]).toArray();
  }
}
// @lc code=end
