import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */
class Solution {
  private Stack<Integer> monoStack;

  public int largestRectangleArea(int[] heights) {
    monoStack = new Stack<>();
    int result = 0;
    monoStack.add(-1);
    int length = heights.length;
    int i = 0;
    while (i < length) {
      if (monoStack.peek() == -1 || heights[i] >= heights[monoStack.peek()])
        monoStack.add(i++);
      else {
        int height = heights[monoStack.pop()];
        int leftIndex = monoStack.peek(), rightIndex = i;
        result = Math.max(result, height * (rightIndex - leftIndex - 1));
      }
    }
    while (monoStack.size() > 1) {
      int height = heights[monoStack.pop()];
      int leftIndex = monoStack.peek(), rightIndex = length;
      result = Math.max(result, height * (rightIndex - leftIndex - 1));
    }
    return result;
  }
}
