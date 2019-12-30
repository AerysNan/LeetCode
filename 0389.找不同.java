/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
  public char findTheDifference(String s, String t) {
    int[] set = new int[26];
    for (char c : s.toCharArray())
      set[c - 'a']++;
    for (char c : t.toCharArray()) {
      if (set[c - 'a'] == 0)
        return c;
      set[c - 'a']--;
    }
    return 0;
  }
}
// @lc code=end

