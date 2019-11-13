/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
  public String convertToTitle(int n) {
    long base = 26, count = 1, value = n;
    while (value > base) {
      value -= base;
      count++;
      base *= 26;
    }
    value--;
    String result = "";
    for (int i = 0; i < count; i++) {
      result = (char) ('A' + value % 26) + result;
      value /= 26;
    }
    return result;
  }
}
// @lc code=end

