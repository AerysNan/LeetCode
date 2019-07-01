/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */
class Solution {
  public int divide(int dividend, int divisor) {
    long m = Math.abs((long) dividend), n = Math.abs((long) divisor);
    long sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
    long result = 0;
    while (m >= n) {
      long value = 1, div = n;
      while (m >= (div << 1)) {
        value <<= 1;
        div <<= 1;
      }
      m -= div;
      result += value;
    }
    if (result * sign > (long) Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    return (int) (result * sign);
  }
}
