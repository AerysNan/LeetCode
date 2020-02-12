/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    ArrayList<Integer> result = new ArrayList<>();
    int m = s.length(), n = p.length(), count = n;
    int[] map = new int[26];
    for (char c : p.toCharArray())
      map[c - 'a']++;
    for (int i = 0; i < m; i++) {
      if (map[s.charAt(i) - 'a'] > 0)
        count--;
      map[s.charAt(i) - 'a']--;
      if (i >= n) {
        if (map[s.charAt(i - n) - 'a'] >= 0)
          count++;
        map[s.charAt(i - n) - 'a']++;
      }
      if (count == 0)
        result.add(i - n + 1);
    }
    return result;
  }
}
// @lc code=end

