/*
 * @lc app=leetcode.cn id=779 lang=java
 *
 * [779] 第K个语法符号
 */

// @lc code=start
class Solution {
  public int kthGrammar(int N, int K) {
    if (N == 1)
      return 0;
    return K % 2 == kthGrammar(N - 1, ((K - 1) >> 1) + 1) ? 1 : 0;
  }
}
// @lc code=end
