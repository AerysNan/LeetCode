/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
  public String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);
    ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
    for (Character character : map.keySet()) {
      int frequency = map.get(character);
      if (bucket[frequency] == null)
        bucket[frequency] = new ArrayList<>();
      bucket[frequency].add(character);
    }
    StringBuilder result = new StringBuilder();
    for (int i = bucket.length - 1; i > 0; i--) {
      if (bucket[i] == null)
        continue;
      for (Character character : bucket[i])
        for (int j = 0; j < i; j++)
          result.append(character);
    }
    return result.toString();
  }
}
// @lc code=end

