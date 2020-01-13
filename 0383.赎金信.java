/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray())
      map.put(c - 'a', map.getOrDefault(c - 'a', 0) + 1);
    for (char c : ransomNote.toCharArray()) {
      int value = map.getOrDefault(c - 'a', 0);
      if (value <= 0)
        return false;
      map.put(c - 'a', value - 1);
    }
    return true;
  }
}
// @lc code=end

