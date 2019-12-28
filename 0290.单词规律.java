/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length() != words.length)
      return false;
    int n = words.length;
    HashMap<Object, Integer> map = new HashMap<>();
    for (Integer i = 0; i < n; i++)
      if (map.put(pattern.charAt(i), i) != map.put(words[i], i))
        return false;
    return true;
  }
}
// @lc code=end

