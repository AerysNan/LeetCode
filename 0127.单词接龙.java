/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> words = new HashSet<String>(wordList);
    HashMap<String, Integer> distance = new HashMap<String, Integer>();
    words.add(beginWord);
    if (!words.contains(endWord))
      return 0;
    LinkedList<String> queue = new LinkedList<String>();
    queue.addFirst(beginWord);
    distance.put(beginWord, 0);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        String str = queue.pollLast();
        ArrayList<String> neighbors = getNeighbors(str, words);
        for (String neighbor : neighbors) {
          if (!distance.containsKey(neighbor)) {
            int value = distance.get(str) + 1;
            if (endWord.equals(neighbor))
              return value + 1;
            distance.put(neighbor, value);
            queue.addFirst(neighbor);
          }
        }
      }
    }
    return 0;
  }

  private ArrayList<String> getNeighbors(String node, HashSet<String> dict) {
    ArrayList<String> result = new ArrayList<String>();
    char[] chars = node.toCharArray();
    for (char ch = 'a'; ch <= 'z'; ch++) {
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == ch)
          continue;
        char tmp = chars[i];
        chars[i] = ch;
        if (dict.contains(String.valueOf(chars)))
          result.add(String.valueOf(chars));
        chars[i] = tmp;
      }
    }
    return result;
  }

}
// @lc code=end

