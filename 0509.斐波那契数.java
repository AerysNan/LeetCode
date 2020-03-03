/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
  public int fib(int N) {
    if (N <= 1)
      return N;
    int a = 0, b = 1;
    for (int i = 2; i <= N; i++) {
      b += a;
      a = b - a;
    }
    return b;
  }
}
// @lc code=end

