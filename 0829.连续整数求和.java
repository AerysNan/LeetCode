/*
 * @lc app=leetcode.cn id=829 lang=java
 *
 * [829] 连续整数求和
 */

// @lc code=start
class Solution {
  public int consecutiveNumbersSum(int N) {
    int result = 0;
    for (int i = 1; N > 0; N -= i++)
      result += N % i == 0 ? 1 : 0;
    return result;
  }
}
// @lc code=end
