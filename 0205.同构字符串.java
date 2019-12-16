/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;
    HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i), c2 = t.charAt(i);
      if (map1.containsKey((int) c1) && map1.get((int) c1) != (int) c2)
        return false;
      if (map2.containsKey((int) c2) && map2.get((int) c2) != (int) c1)
        return false;
      if (!map1.containsKey((int) c1))
        map1.put((int) c1, (int) c2);
      if (!map2.containsKey((int) c2))
        map2.put((int) c2, (int) c1);
    }
    return true;
  }
}
// @lc code=end

