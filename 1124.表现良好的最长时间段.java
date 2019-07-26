import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1124 lang=java
 *
 * [1124] 表现良好的最长时间段
 */
class Solution {
  public int longestWPI(int[] hours) {
    int n = hours.length;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++)
      prefix[i + 1] = prefix[i] + (hours[i] > 8 ? 1 : -1);
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = prefix.length - 1; i >= 0; i--)
      if (stack.isEmpty() || prefix[i] > prefix[stack.peekLast()])
        stack.addLast(i);
    int result = 0;
    for (int i = 0; i < prefix.length; i++)
      while (!stack.isEmpty() && prefix[i] < prefix[stack.peekLast()])
        result = Math.max(result, stack.pollLast() - i);
    return result;
  }
}
