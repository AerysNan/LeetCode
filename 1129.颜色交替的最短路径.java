import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 */
class Solution {
  ArrayList<Integer>[] adjR;
  ArrayList<Integer>[] adjB;

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    ArrayList<Integer>[] adjR = (ArrayList<Integer>[]) new ArrayList[n];
    ArrayList<Integer>[] adjB = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjR[i] = new ArrayList<>();
      adjB[i] = new ArrayList<>();
    }
    for (int[] edge : red_edges)
      adjR[edge[0]].add(edge[1]);
    for (int[] edge : blue_edges)
      adjB[edge[0]].add(edge[1]);
    int[] resultR = BFS(n, adjR, adjB);
    int[] resultB = BFS(n, adjB, adjR);
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (resultR[i] == -1)
        result[i] = resultB[i];
      else if (resultB[i] == -1)
        result[i] = resultR[i];
      else
        result[i] = Math.min(resultR[i], resultB[i]);
    }
    return result;
  }

  int[] BFS(int n, ArrayList<Integer>[] adjR, ArrayList<Integer>[] adjB) {
    int[] result = new int[n];
    boolean[][] visited = new boolean[n][2];
    for (int i = 0; i < n; i++)
      result[i] = -1;
    LinkedList<Integer> queue = new LinkedList<>();
    int step = 1;
    boolean color = true;
    visited[0][0] = true;
    result[0] = 0;
    queue.add(0);
    while (!queue.isEmpty()) {
      ArrayList<Integer> buffer = new ArrayList<>();
      while (!queue.isEmpty()) {
        int point = queue.pollFirst();
        ArrayList<Integer>[] adj = color ? adjR : adjB;
        for (int p : adj[point]) {
          if (visited[p][color ? 0 : 1])
            continue;
          visited[p][color ? 0 : 1] = true;
          result[p] = result[p] == -1 ? step : Math.min(result[p], step);
          buffer.add(p);
        }
      }
      for (int p : buffer)
        queue.addLast(p);
      step++;
      color = !color;
    }
    return result;
  }
}
