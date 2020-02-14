/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
  public int arrangeCoins(int n) {
    int result = 0;
    while (n >= result)
      n -= result++;
    return result - 1;
  }
}
// @lc code=end

