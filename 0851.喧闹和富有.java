/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  int[] result, quiet;

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    this.quiet = quiet;
    result = new int[n];
    Arrays.fill(result, -1);
    for (int i = 0; i < n; i++)
      graph.add(new ArrayList<>());
    for (int[] rich : richer)
      graph.get(rich[1]).add(rich[0]);
    for (int i = 0; i < n; i++)
      if (result[i] == -1)
        dfs(i);
    return result;
  }

  int dfs(int current) {
    if (result[current] != -1)
      return result[current];
    int value = current;
    for (int next : graph.get(current)) {
      int candidate = dfs(next);
      if (quiet[candidate] < quiet[value])
        value = candidate;
    }
    result[current] = value;
    return value;
  }
}
// @lc code=end
