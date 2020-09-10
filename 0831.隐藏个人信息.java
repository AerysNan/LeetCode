/*
 * @lc app=leetcode.cn id=831 lang=java
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
class Solution {
  public String maskPII(String S) {
    int atIndex = S.indexOf('@');
    if (atIndex >= 0)
      return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();
    else {
      String digits = S.replaceAll("\\D+", ""), local = "***-***-" + digits.substring(digits.length() - 4);
      if (digits.length() == 10)
        return local;
      String result = "+";
      for (int i = 0; i < digits.length() - 10; ++i)
        result += "*";
      return result + "-" + local;
    }
  }
}
// @lc code=end
