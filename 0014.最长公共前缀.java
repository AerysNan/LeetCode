/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";
    for (int i = 0;; i++) {
      if (i >= strs[0].length())
        return strs[0].substring(0, i);
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i < strs[j].length() && strs[j].charAt(i) == c)
          continue;
        return strs[0].substring(0, i);
      }
    }
  }
}
