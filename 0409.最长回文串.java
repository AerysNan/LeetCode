/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int longestPalindrome(String s) {
    int result = 0;
    HashSet<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        set.remove(c);
        result += 2;
      } else
        set.add(c);
    }
    return result + (set.isEmpty() ? 0 : 1);
  }
}
// @lc code=end

