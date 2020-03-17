/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int countCharacters(String[] words, String chars) {
    int result = 0;
    HashMap<Character, Integer> map = wordToMap(chars);
    for (String word : words) {
      boolean valid = true;
      HashMap<Character, Integer> wordMap = wordToMap(word);
      for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
        if (!map.containsKey(entry.getKey()) || map.get(entry.getKey()) < entry.getValue()) {
          valid = false;
          break;
        }
      }
      if (valid)
        result += word.length();
    }
    return result;
  }

  HashMap<Character, Integer> wordToMap(String word) {
    HashMap<Character, Integer> result = new HashMap<>();
    for (char c : word.toCharArray())
      result.put(c, result.getOrDefault(c, 0) + 1);
    return result;
  }
}
// @lc code=end

