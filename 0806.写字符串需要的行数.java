/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
  public int[] numberOfLines(int[] widths, String S) {
    int result = 1, current = 0;
    for (char c : S.toCharArray()) {
      current += widths[c - 'a'];
      if (current > 100) {
        result++;
        current = widths[c - 'a'];
      }
    }
    return new int[] { result, current };
  }
}
// @lc code=end
