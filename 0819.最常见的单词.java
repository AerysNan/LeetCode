/*
* @lc app=leetcode.cn id=819 lang=java
*
* [819] 最常见的单词
*/

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
    HashSet<String> set = new HashSet<>();
    for (String ban : banned)
      set.add(ban);
    paragraph = paragraph.replaceAll("[!\\?',;\\.]", " ").toLowerCase();
    String[] words = paragraph.split("\\s+");
    HashMap<String, Integer> map = new HashMap<>();
    String result = "";
    int max = -1;
    for (String word : words) {
      if (set.contains(word))
        continue;
      int count = map.getOrDefault(word, 0) + 1;
      System.out.println(word + " " + count);
      if (count > max) {
        max = count;
        result = word;
      }
      map.put(word, count);
    }
    return result;
  }
}
// @lc code=end
