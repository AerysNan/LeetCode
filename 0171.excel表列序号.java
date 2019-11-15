/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
  public int titleToNumber(String s) {
    int n = s.length();
    int result = 0, current = 26;
    for (int i = 1; i < n; i++) {
      result += current;
      current *= 26;
    }
    int value = 0;
    for (int i = 0; i < n; i++)
      value = value * 26 + (s.charAt(i) - 'A');
    return result + value + 1;
  }
}
// @lc code=end

