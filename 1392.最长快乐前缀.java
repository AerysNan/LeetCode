/*
 * @lc app=leetcode.cn id=5367 lang=java
 *
 * [5367] 最长快乐前缀
 */

// @lc code=start
class Solution {
  public String longestPrefix(String s) {
    int[] next = getNext(s);
    int n = next[s.length()];
    return s.substring(0, n);
  }

  int[] getNext(String s) {
    int[] next = new int[s.length() + 1];
    int i = 0, j = -1;
    next[0] = -1;
    while (i < s.length()) {
      if (j == -1 || s.charAt(j) == s.charAt(i))
        next[++i] = ++j;
      else
        j = next[j];
    }
    return next;
  }
}
// @lc code=end

