/*
 * @lc app=leetcode.cn id=1359 lang=java
 *
 * [1359] 有效的快递序列数目
 */

// @lc code=start
class Solution {
  public int countOrders(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
      int v = i * (2 * i - 1);
      result = result * v % (long) (1e9 + 7);
    }
    return (int) result;
  }
}
// @lc code=end

