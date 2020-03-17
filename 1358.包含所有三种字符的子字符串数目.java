/*
 * @lc app=leetcode.cn id=1358 lang=java
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length(), l = 0, r = 0, result = 0;
    int[] map = new int[3];
    while (r < n) {
      while (r < n && (map[0] == 0 || map[1] == 0 || map[2] == 0))
        map[s.charAt(r++) - 'a']++;
      while (l < r && map[0] != 0 && map[1] != 0 && map[2] != 0) {
        result += n - r + 1;
        map[s.charAt(l++) - 'a']--;
      }
    }
    return result;
  }
}
// @lc code=end

