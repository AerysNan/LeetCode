/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> current = new LinkedList<>();
    current.addLast(0);
    walk(0, graph, result, current);
    return result;
  }

  void walk(int index, int[][] graph, ArrayList<List<Integer>> result, LinkedList<Integer> current) {
    if (index == graph.length - 1) {
      result.add(new LinkedList<>(current));
      return;
    }
    for (int next : graph[index]) {
      current.addLast(next);
      walk(next, graph, result, current);
      current.pollLast();
    }
  }
}
// @lc code=end
