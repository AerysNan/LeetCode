/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0)
      return 0;
    int[] hash = new int[256];
    int begin = 0, end = 1, result = 1;
    hash[s.charAt(0)] = 1;
    while (begin < s.length()) {
      if (end >= s.length() || hash[s.charAt(end)] != 0) {
        hash[s.charAt(begin)]--;
        begin++;
      } else {
        hash[s.charAt(end)]++;
        end++;
      }
      result = Math.max(result, end - begin);
    }
    return result;
  }
}
