/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
  public String addStrings(String num1, String num2) {
    int m = num1.length() - 1, n = num2.length() - 1;
    int carry = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (m >= 0 || n >= 0) {
      int n1 = m < 0 ? 0 : num1.charAt(m--) - '0';
      int n2 = n < 0 ? 0 : num2.charAt(n--) - '0';
      int sum = n1 + n2 + carry;
      stringBuilder.append(sum % 10);
      carry = sum / 10;
    }
    if (carry > 0)
      stringBuilder.append(1);
    return stringBuilder.reverse().toString();
  }
}
// @lc code=end

