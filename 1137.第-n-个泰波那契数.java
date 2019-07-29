/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */
class Solution {
  public int tribonacci(int n) {
    int[] result = new int[Math.max(3, n + 1)];
    result[0] = 0;
    result[1] = 1;
    result[2] = 1;
    for (int i = 3; i <= n; i++)
      result[i] = result[i - 1] + result[i - 2] + result[i - 3];
    return result[n];

  }
}
