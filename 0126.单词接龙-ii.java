/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public List<List<String>> findLadders(String start, String end, List<String> wordList) {
    HashSet<String> words = new HashSet<String>(wordList);
    List<List<String>> result = new ArrayList<>();
    HashMap<String, ArrayList<String>> adjMap = new HashMap<String, ArrayList<String>>();
    HashMap<String, Integer> distance = new HashMap<String, Integer>();
    LinkedList<String> current = new LinkedList<String>();
    words.add(start);
    bfs(start, end, words, adjMap, distance);
    dfs(start, end, words, adjMap, distance, current, result);
    return result;
  }

  private void bfs(String start, String end, Set<String> words,
      HashMap<String, ArrayList<String>> adjMap, HashMap<String, Integer> distance) {
    for (String str : words)
      adjMap.put(str, new ArrayList<String>());
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    distance.put(start, 0);
    while (!queue.isEmpty()) {
      int count = queue.size();
      boolean foundEnd = false;
      for (int i = 0; i < count; i++) {
        String str = queue.poll();
        ArrayList<String> neighbors = getNeighbors(str, words);
        for (String neighbor : neighbors) {
          adjMap.get(str).add(neighbor);
          if (!distance.containsKey(neighbor)) {
            distance.put(neighbor, distance.get(str) + 1);
            if (end.equals(neighbor))
              foundEnd = true;
            else
              queue.offer(neighbor);
          }
        }
      }
      if (foundEnd)
        break;
    }
  }

  private ArrayList<String> getNeighbors(String node, Set<String> dict) {
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

  private void dfs(String start, String end, Set<String> dict,
      HashMap<String, ArrayList<String>> adjMap, HashMap<String, Integer> distance,
      LinkedList<String> current, List<List<String>> result) {
    current.addLast(start);
    if (end.equals(start))
      result.add(new LinkedList<String>(current));
    else
      for (String next : adjMap.get(start))
        if (distance.get(next) == distance.get(start) + 1)
          dfs(next, end, dict, adjMap, distance, current, result);
    current.pollLast();
  }
}
// @lc code=end
