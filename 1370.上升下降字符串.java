/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
  public String sortString(String s) {
    int n = s.length();
    if (n == 0)
      return "";
    int[] map = new int[26];
    char[] result = new char[n];
    for (int i = 0; i < n; i++)
      map[s.charAt(i) - 'a']++;
    int count = 0;
    while (count < n) {
      for (int i = 0; i < 26; ++i) {
        if (map[i] > 0) {
          result[count++] = (char) ('a' + i);
          map[i]--;
        }
      }
      for (int i = 25; i >= 0; --i) {
        if (map[i] > 0) {
          result[count++] = (char) ('a' + i);
          map[i]--;
        }
      }
    }
    return new String(result);
  }
}
// @lc code=end

