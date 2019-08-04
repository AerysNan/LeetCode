/*
 * @lc app=leetcode.cn id=1147 lang=java
 *
 * [1147] 段式回文
 */
class Solution {
  public int longestDecomposition(String text) {
    return matchString(text, 0, text.length() - 1);
  }

  int matchString(String text, int l, int h) {
    int n = h - l + 1;
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    for (int i = 1; i <= n / 2; i++) {
      boolean valid = true;
      for (int j = 0; j < i; j++) {
        if (text.charAt(l + j) != text.charAt(h - i + j + 1)) {
          valid = false;
          break;
        }
      }
      if (valid)
        return 2 + matchString(text, l + i, h - i);
    }
    return 1;
  }
}
