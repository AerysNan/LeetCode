/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
  int result = Integer.MAX_VALUE;

  public int minMutation(String start, String end, String[] bank) {
    dfs(start, end, bank, 0, new boolean[bank.length]);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  void dfs(String src, String trg, String[] bank, int steps, boolean[] visited) {
    if (steps >= result)
      return;
    for (int i = 0; i < bank.length; i++) {
      if (visited[i] || !valid(src, bank[i]))
        continue;
      if (bank[i].equals(trg)) {
        result = Math.min(result, steps + 1);
        return;
      }
      visited[i] = true;
      dfs(bank[i], trg, bank, steps + 1, visited);
      visited[i] = false;
    }
  }

  boolean valid(String s, String d) {
    if (s.equals(d))
      return false;
    boolean found = false;
    for (int i = 0; i < 8; i++) {
      if (s.charAt(i) != d.charAt(i)) {
        if (found)
          return false;
        found = true;
      }
    }
    return true;
  }
}
// @lc code=end

