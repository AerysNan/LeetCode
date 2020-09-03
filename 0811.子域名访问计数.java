/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String cpdpmain : cpdomains) {
      String[] chunks = cpdpmain.split(" ");
      int count = Integer.parseInt(chunks[0]);
      char[] array = chunks[1].toCharArray();
      map.put(chunks[1], map.getOrDefault(chunks[1], 0) + count);
      for (int i = 1; i < array.length; i++) {
        if (array[i] == '.') {
          String domain = chunks[1].substring(i + 1);
          map.put(domain, map.getOrDefault(domain, 0) + count);
        }
      }
    }
    ArrayList<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> e : map.entrySet())
      result.add(e.getValue() + " " + e.getKey());
    return result;
  }
}
// @lc code=end
