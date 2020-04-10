import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1409 lang=java
 *
 * [1409] 查询带键的排列
 */

// @lc code=start
class Solution {
  public int[] processQueries(int[] queries, int m) {
    int[] next = new int[m + 1], prev = new int[m + 1];
    for (int i = 1; i <= m; i++) {
      next[i] = i + 1;
      prev[i] = i - 1;
    }
    prev[1] = -1;
    next[m] = -1;
    int n = queries.length, head = 1;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int value = queries[i], current = head, index = 0;
      while (current != value) {
        current = next[current];
        index++;
      }
      result[i] = index;
      if (current != head) {
        if (prev[current] > 0)
          next[prev[current]] = next[current];
        if (next[current] > 0)
          prev[next[current]] = prev[current];
        next[current] = head;
        prev[current] = -1;
        prev[head] = current;
        head = current;
      }
    }
    return result;
  }
}
// @lc code=end

