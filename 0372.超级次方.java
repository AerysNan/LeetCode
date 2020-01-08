/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
  public int superPow(int a, int[] b) {
    int result = 1;
    a = a % 1337;
    for (int i = 0; i < b.length; i++)
      result = pow(result, 10) * pow(a, b[i]) % 1337;
    return result;
  }

  int pow(int a, int b) {
    if (b == 0)
      return 1;
    if (b == 1)
      return a % 1337;
    return pow(a % 1337, b / 2) * pow(a % 1337, b - b / 2) % 1337;
  }
}
// @lc code=end

