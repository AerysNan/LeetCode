/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */
class Solution {
  public boolean isPalindrome(String s) {
    char[] string = new char[s.length()];
    String lower = s.toLowerCase();
    int n = s.length(), index = 0;
    for (int i = 0; i < n; i++) {
      char c = lower.charAt(i);
      if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
        string[index++] = c;
    }
    for (int i = 0; i < index / 2; i++)
      if (string[i] != string[index - 1 - i])
        return false;
    return true;
  }
}
