import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (36.26%)
 * Total Accepted:    4K
 * Total Submissions: 10.9K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
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
