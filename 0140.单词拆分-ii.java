/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
  HashMap<String, ArrayList<String>> map;

  public List<String> wordBreak(String s, List<String> wordDict) {
    map = new HashMap<>();
    HashSet<String> set = new HashSet<>(wordDict);
    return search(s, set);
  }

  ArrayList<String> search(String s, HashSet<String> wordDict) {
    if (map.containsKey(s))
      return map.get(s);
    ArrayList<String> result = new ArrayList<>();
    if (s.isEmpty()) {
      result.add("");
      return result;
    }
    for (String word : wordDict) {
      if (!s.startsWith(word))
        continue;
      ArrayList<String> sub = search(s.substring(word.length()), wordDict);
      for (String str : sub)
        result.add(word + (str.isEmpty() ? "" : " ") + str);
    }
    map.put(s, result);
    return result;
  }
}
// @lc code=end

