/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
  public int compress(char[] chars) {
    int index = 0, n = chars.length, pos = 0;
    while (index < n) {
      int count = 0;
      char current = chars[index];
      while (index < n && chars[index] == current) {
        index++;
        count++;
      }
      chars[pos] = current;
      if (count > 1) {
        String value = String.valueOf(count);
        for (char c : value.toCharArray())
          chars[++pos] = c;
      }
      pos++;
    }
    return pos;
  }
}
// @lc code=end

