/*
 * @lc app=leetcode.cn id=1345 lang=java
 *
 * [1345] 跳跃游戏 IV
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
  public int minJumps(int[] arr) {
    int n = arr.length;
    int[] distance = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    boolean[] visited = new boolean[n];
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      if (!adj.containsKey(arr[i]))
        adj.put(arr[i], new ArrayList<>());
      adj.get(arr[i]).add(i);
    }
    distance[n - 1] = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.addFirst(n - 1);
    while (!queue.isEmpty()) {
      int u = queue.pollLast();
      if (u - 1 >= 0 && !visited[u - 1] && adj.containsKey(arr[u - 1])) {
        distance[u - 1] = Math.min(distance[u - 1], distance[u] + 1);
        visited[u - 1] = true;
        queue.addFirst(u - 1);
      }
      if (u + 1 < n && !visited[u + 1] && adj.containsKey(arr[u + 1])) {
        distance[u + 1] = Math.min(distance[u + 1], distance[u] + 1);
        visited[u + 1] = true;
        queue.addFirst(u + 1);
      }
      if (adj.containsKey(arr[u])) {
        for (int v : adj.get(arr[u])) {
          if (!visited[v]) {
            visited[v] = true;
            distance[v] = Math.min(distance[u] + 1, distance[v]);
            queue.addFirst(v);
          }
        }
        adj.remove(arr[u]);
      }
    }
    return distance[0];
  }
}
// @lc code=end

