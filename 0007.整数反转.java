/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
  public int reverse(int x) {
    int mark = x >= 0 ? 1 : -1;
    String s = String.valueOf(Math.abs((long) x));
    String r = "";
    for (char c : s.toCharArray())
      r = c + r;
    long result = Long.parseLong(r) * mark;
    return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
  }
}
