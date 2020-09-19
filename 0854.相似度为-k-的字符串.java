/*
* @lc app=leetcode.cn id=854 lang=java
*
* [854] 相似度为 K 的字符串
*/

// @lc code=start
import java.util.LinkedList;
import java.util.HashSet;

class Solution {
  public int kSimilarity(String A, String B) {
    if (A.equals(B))
      return 0;
    LinkedList<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    queue.add(A);
    visited.add(A);
    int result = 0;
    while (!queue.isEmpty()) {
      result++;
      for (int size = queue.size(); size > 0; size--) {
        String s = queue.poll();
        int i = 0;
        while (s.charAt(i) == B.charAt(i))
          i++;
        for (int j = i + 1; j < s.length(); j++) {
          if (s.charAt(j) == B.charAt(j) || s.charAt(j) != B.charAt(i))
            continue;
          char[] array = s.toCharArray();
          char c = array[i];
          array[i] = array[j];
          array[j] = c;
          String next = new String(array);
          if (next.equals(B))
            return result;
          if (visited.add(next))
            queue.offer(next);
        }
      }
    }
    return -1;
  }
}
// @lc code=end
