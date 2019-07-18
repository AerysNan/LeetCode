/*
 * @lc app=leetcode.cn id=1016 lang=java
 *
 * [1016] 子串能表示从 1 到 N 数字的二进制串
 */
class Solution {
  public boolean queryString(String S, int N) {
    for (int i = N; i > N / 2; i--)
      if (!S.contains(Integer.toBinaryString(i)))
        return false;
    return true;
  }
}
