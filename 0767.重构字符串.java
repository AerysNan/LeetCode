/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
import java.util.PriorityQueue;

class Pair {
  char value;
  int count;

  public Pair(char value, int count) {
    this.value = value;
    this.count = count;
  }
}

class Solution {
  public String reorganizeString(String S) {
    PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
    int[] map = new int[26];
    for (char c : S.toCharArray())
      map[c - 'a']++;
    for (int i = 0; i < 26; i++) {
      if (map[i] > (S.length() + 1) / 2)
        return "";
      if (map[i] != 0)
        queue.add(new Pair((char) (i + 'a'), map[i]));
    }
    StringBuilder result = new StringBuilder();
    while (queue.size() > 1) {
      Pair p1 = queue.poll(), p2 = queue.poll();
      result.append(p1.value).append(p2.value);
      if (--p1.count > 0)
        queue.add(p1);
      if (--p2.count > 0)
        queue.add(p2);
    }
    if (!queue.isEmpty())
      result.append(queue.poll().value);
    return result.toString();
  }
}
// @lc code=end
