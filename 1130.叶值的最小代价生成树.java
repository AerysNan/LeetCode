import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1130 lang=java
 *
 * [1130] 叶值的最小代价生成树
 */
class Solution {
  public int mctFromLeafValues(int[] arr) {
    int result = 0, n = arr.length;
    Stack<Integer> stack = new Stack<>();
    stack.push(Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      while (stack.peek() <= arr[i]) {
        int value = stack.pop();
        result += value * Math.min(stack.peek(), arr[i]);
      }
      stack.push(arr[i]);
    }
    while (stack.size() > 2)
      result += stack.pop() * stack.peek();
    return result;
  }
}
