/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
  public void reverseString(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
      char tmp = s[i];
      s[i] = s[n - 1 - i];
      s[n - 1 - i] = tmp;
    }
  }
}
// @lc code=end

