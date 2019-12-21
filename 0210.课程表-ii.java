/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] degree = new int[numCourses];
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
      map.add(new ArrayList<>());
    for (int[] prerequisite : prerequisites) {
      map.get(prerequisite[1]).add(prerequisite[0]);
      degree[prerequisite[0]]++;
    }
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      for (int j = 0; j < numCourses; j++) {
        if (degree[j] == 0) {
          result.add(j);
          degree[j] = -1;
          for (int id : map.get(j))
            degree[id]--;
        }
      }
    }
    if (result.size() != numCourses)
      return new int[0];
    return result.stream().mapToInt(x -> x).toArray();
  }
}
// @lc code=end

