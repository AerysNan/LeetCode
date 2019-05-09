/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */
class Solution {
  private int[][] transfer = { { 4, 1 }, { 3, 2 }, { -1, 2 }, { 3, -1 }, { 4, -1 } };

  public boolean detectCapitalUse(String word) {
    int state = 0, n = word.length();
    for (int i = 0; i < n; i++) {
      char c = word.charAt(i);
      state = transfer[state][(c >= 'a' && c <= 'z') ? 0 : 1];
      if (state == -1)
        return false;
    }
    return true;
  }
}
