/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
  public String toHex(int num) {
    if (num < 10 && num >= 0)
      return Integer.toString(num);
    char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 8 && num != 0; i++) {
      stringBuilder.insert(0, hex[num & 15]);
      num >>= 4;
    }
    return stringBuilder.toString();
  }
}
// @lc code=end

