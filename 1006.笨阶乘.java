/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */
class Solution {
  public int clumsy(int N) {
    int value = fac(N);
    return N <= 3 ? -value : (value + 2 * (N * (N - 1) / (N - 2)));
  }

  int fac(int N) {
    switch (N) {
    case 1:
      return -1;
    case 2:
      return -2;
    case 3:
      return -6;
    case 4:
      return -5;
    default:
      return -N * (N - 1) / (N - 2) + N - 3 + fac(N - 4);
    }
  }
}
