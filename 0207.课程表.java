/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
      graph.add(new ArrayList<>());
    boolean[] visited = new boolean[numCourses];
    for (int[] prerequisite : prerequisites)
      graph.get(prerequisite[1]).add(prerequisite[0]);
    for (int i = 0; i < numCourses; i++)
      if (!dfs(graph, visited, i))
        return false;
    return true;
  }

  boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int course) {
    if (visited[course])
      return false;
    visited[course] = true;
    ArrayList<Integer> adjacent = graph.get(course);
    for (int i = 0; i < adjacent.size(); i++)
      if (!dfs(graph, visited, adjacent.get(i)))
        return false;
    visited[course] = false;
    return true;
  }
}
// @lc code=end
