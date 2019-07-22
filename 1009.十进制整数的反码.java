/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */
class Solution {
  public int bitwiseComplement(int N) {
    if (N == 0)
      return 1;
    int value = 1;
    while (value <= N)
      value <<= 1;
    return value - N - 1;
  }
}
