/*
 * @lc app=leetcode.cn id=1163 lang=java
 *
 * [1163] 按字典序排在最后的子串
 */

// @lc code=start
class Solution {
  public String lastSubstring(String s) {
    int l = 0, r = 1, k = 0, n = s.length();
    char[] array = s.toCharArray();
    while (k < n && l < n && r < n) {
      if (array[(l + k) % n] == array[(r + k) % n])
        k++;
      else {
        if (array[(l + k) % n] < array[(r + k) % n])
          l += k + 1;
        else
          r += k + 1;
        k = 0;
        if (l == r)
          r++;
      }
    }
    return s.substring(Math.min(l, r));
  }
}
// @lc code=end

