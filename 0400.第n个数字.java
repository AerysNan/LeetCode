/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 */

// @lc code=start
class Solution {
  public int findNthDigit(int n) {
    long digit = 1, base = 1, total = 9;
    while (n - total > 0) {
      n -= total;
      digit++;
      base *= 10;
      total = 9 * base * digit;
      if (total < 0)
        break;
    }
    long number = base + (n - 1) / digit;
    return String.valueOf(number).charAt((int) ((n - 1) % digit)) - '0';
  }
}
// @lc code=end

