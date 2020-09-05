/*
 * @lc app=leetcode.cn id=815 lang=java
 *
 * [815] 公交路线
 */

// @lc code=start
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    if (S == T)
      return 0;
    int n = routes.length;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      Arrays.sort(routes[i]);
      graph.add(new ArrayList<>());
    }
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> targets = new HashSet<>();
    LinkedList<Point> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (intersect(routes[i], routes[j])) {
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
      }
    }
    for (int i = 0; i < n; ++i) {
      if (Arrays.binarySearch(routes[i], S) >= 0) {
        visited.add(i);
        queue.offer(new Point(i, 0));
      }
      if (Arrays.binarySearch(routes[i], T) >= 0)
        targets.add(i);
    }
    while (!queue.isEmpty()) {
      Point p = queue.poll();
      int node = p.x, depth = p.y;
      if (targets.contains(node))
        return depth + 1;
      for (int next : graph.get(node)) {
        if (!visited.contains(next)) {
          visited.add(next);
          queue.offer(new Point(next, depth + 1));
        }
      }
    }
    return -1;
  }

  public boolean intersect(int[] A, int[] B) {
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
      if (A[i] == B[j])
        return true;
      if (A[i] < B[j])
        i++;
      else
        j++;
    }
    return false;
  }
}
// @lc code=end
