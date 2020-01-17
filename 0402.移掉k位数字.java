/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public String removeKdigits(String num, int k) {
    if (k <= 0)
      return num;
    if (num.length() == 0 || k >= num.length())
      return "0";
    LinkedList<Character> stack = new LinkedList<>();
    for (char c : num.toCharArray()) {
      while (!stack.isEmpty() && stack.peekLast() > c && k > 0) {
        stack.pollLast();
        k--;
      }
      stack.addLast(c);
    }
    while (k > 0) {
      stack.pollLast();
      k--;
    }
    while (!stack.isEmpty() && stack.peekFirst() == '0')
      stack.pollFirst();
    if (stack.isEmpty())
      return "0";
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : stack)
      stringBuilder.append(c);
    return stringBuilder.toString();
  }
}
// @lc code=end

