import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* @lc app=leetcode.cn id=30 lang=java
*
* [30] 串联所有单词的子串
*/

// @lc code=start
class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    ArrayList<Integer> result = new ArrayList<>();
    if (s.length() == 0 || words.length == 0)
      return result;
    HashMap<String, Integer> map = new HashMap<>();
    for (String w : words)
      map.put(w, map.getOrDefault(w, 0) + 1);
    int n = s.length(), m = words[0].length(), c = words.length;
    for (int i = 0; i <= n - m * c; i++) {
      String clip = s.substring(i, i + m * c);
      HashMap<String, Integer> countMap = new HashMap<>();
      boolean valid = true;
      for (int j = 0; j < c; j++) {
        String key = clip.substring(j * m, j * m + m);
        int value = countMap.getOrDefault(key, 0) + 1;
        if (value > map.getOrDefault(key, 0)) {
          valid = false;
          break;
        }
        countMap.put(key, value);
      }
      if (valid)
        result.add(i);
    }
    return result;
  }
}
// @lc code=end
