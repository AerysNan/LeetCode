/*
 * @lc app=leetcode.cn id=996 lang=java
 *
 * [996] 正方形数组的数目
 */

// @lc code=start
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
  int n;
  HashMap<Integer, ArrayList<Integer>> graph;
  Integer[][] memo;

  public int numSquarefulPerms(int[] A) {
    n = A.length;
    graph = new HashMap<>();
    memo = new Integer[n][1 << n];
    for (int i = 0; i < n; i++)
      graph.put(i, new ArrayList<>());
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++) {
        int r = (int) (Math.sqrt(A[i] + A[j]) + 0.5);
        if (r * r == A[i] + A[j]) {
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
      }
    int[] factorial = new int[20];
    factorial[0] = 1;
    for (int i = 1; i < 20; i++)
      factorial[i] = i * factorial[i - 1];
    int result = 0;
    for (int i = 0; i < n; i++)
      result += dfs(i, 1 << i);
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int x : A)
      count.put(x, count.getOrDefault(x, 0) + 1);
    for (int v : count.values())
      result /= factorial[v];
    return result;
  }

  public int dfs(int node, int visited) {
    if (visited == (1 << n) - 1)
      return 1;
    if (memo[node][visited] != null)
      return memo[node][visited];
    int result = 0;
    for (int next : graph.get(node))
      if (((visited >> next) & 1) == 0)
        result += dfs(next, visited | (1 << next));
    memo[node][visited] = result;
    return result;
  }
}
// @lc code=end
