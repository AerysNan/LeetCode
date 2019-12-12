/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int i = 0;
    for (; m != n; i++, m >>= 1, n >>= 1);
    return n << i;
  }
}
// @lc code=end

