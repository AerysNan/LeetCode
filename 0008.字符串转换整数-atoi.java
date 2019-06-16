/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.equals(""))
      return 0;
    boolean neg = false;
    int begin = 0;
    if (str.charAt(0) == '-') {
      neg = true;
      begin = 1;
    } else if (str.charAt(0) == '+') {
      neg = false;
      begin = 1;
    }
    int end = begin;
    while (end < str.length() && str.charAt(end) >= '0' && str.charAt(end) <= '9')
      end++;
    if (end == begin)
      return 0;
    String s = str.substring(begin, end);
    double value = (neg ? (-1) : 1) * Double.parseDouble(s);
    if (value > (double) Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    if (value < (double) Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    return (int) value;
  }
}
