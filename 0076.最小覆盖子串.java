/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
  public String minWindow(String s, String t) {
    if (s == null || s.isEmpty() || t == null | t.isEmpty())
      return "";
    int n = s.length(), m = t.length();
    int l = 0, r = 0, count = 0, length = Integer.MAX_VALUE, index = -1;
    int[] charset = new int[256];
    int[] tempset = new int[256];
    for (int i = 0; i < m; i++)
      charset[t.charAt(i)]++;
    while (r < n) {
      if (count < m) {
        char c = s.charAt(r++);
        tempset[c]++;
        if (tempset[c] <= charset[c])
          count++;
      }
      while (count == m) {
        if (r - l < length) {
          length = r - l;
          index = l;
        }
        char c = s.charAt(l++);
        tempset[c]--;
        if (tempset[c] < charset[c])
          count--;
      }
    }
    return index < 0 ? "" : s.substring(index, index + length);
  }
}
// @lc code=end
