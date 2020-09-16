/*
 * @lc app=leetcode.cn id=847 lang=java
 *
 * [847] 访问所有节点的最短路径
 */

// @lc code=start\
import java.util.LinkedList;
import java.util.Arrays;

class State {
  int visited, current;

  State(int visited, int current) {
    this.visited = visited;
    this.current = current;
  }
}

class Solution {
  public int shortestPathLength(int[][] graph) {
    int n = graph.length, target = (1 << n) - 1;
    LinkedList<State> queue = new LinkedList<>();
    int[][] dist = new int[1 << n][n];
    for (int[] row : dist)
      Arrays.fill(row, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      queue.offer(new State(1 << i, i));
      dist[1 << i][i] = 0;
    }
    while (!queue.isEmpty()) {
      State node = queue.poll();
      int d = dist[node.visited][node.current];
      if (node.visited == target)
        return d;
      for (int next : graph[node.current]) {
        int visited = node.visited | (1 << next);
        if (d + 1 < dist[visited][next]) {
          dist[visited][next] = d + 1;
          queue.offer(new State(visited, next));
        }
      }
    }
    return -1;
  }
}

// @lc code=end
