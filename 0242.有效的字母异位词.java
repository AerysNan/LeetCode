/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;
    int[] map = new int[26];
    for (char c : s.toCharArray())
      map[c - 'a']++;
    for (char c : t.toCharArray()) {
      if (map[c - 'a'] == 0)
        return false;
      map[c - 'a']--;
    }
    return true;
  }
}
// @lc code=end

