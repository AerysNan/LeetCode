/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */
class Solution {
  int[][] cache = new int[31][1001];

  public int numRollsToTarget(int d, int f, int target) {
    return dfs(0, d, f, target);
  }

  private int dfs(int n, int d, int f, int target) {
    if (cache[n][target] > 0)
      return cache[n][target];
    if (cache[n][target] == -1)
      return 0;
    if (n == d - 1)
      return (target > 0 && f >= target) ? 1 : 0;
    int count = 0, range = Math.min(f, target);
    for (int i = 1; i <= range; i++)
      count = (count + dfs(n + 1, d, f, target - i)) % 1000000007;
    cache[n][target] = count == 0 ? -1 : count;
    return count;
  }
}
