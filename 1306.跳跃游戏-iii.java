/*
 * @lc app=leetcode.cn id=1306 lang=java
 *
 * [1306] 跳跃游戏 III
 */

// @lc code=start
class Solution {
  public boolean canReach(int[] arr, int start) {
    int n = arr.length;
    boolean[] visited = new boolean[n];
    visited[start] = true;
    dfs(arr, start, visited);
    for (int i = 0; i < n; i++)
      if (arr[i] == 0 && visited[i])
        return true;
    return false;
  }

  void dfs(int[] arr, int current, boolean[] visited) {
    if (arr[current] == 0)
      return;
    int l = current - arr[current];
    if (l >= 0 && !visited[l]) {
      visited[l] = true;
      dfs(arr, l, visited);
    }
    int r = current + arr[current];
    if (r < arr.length && !visited[r]) {
      visited[r] = true;
      dfs(arr, r, visited);
    }
  }
}
// @lc code=end

