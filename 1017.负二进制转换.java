/*
 * @lc app=leetcode.cn id=1017 lang=java
 *
 * [1017] 负二进制转换
 */
class Solution {
  public String baseNeg2(int N) {
    if (N == 0)
      return "0";
    String result = "";
    while (N != 0) {
      int mod = N % -2;
      N /= -2;
      if (mod == -1)
        N += 1;
      result = Math.abs(mod) + result;

    }
    return result;
  }
}
