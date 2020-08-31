/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    if (rooms.size() <= 1)
      return true;
    int n = rooms.size(), count = 1;
    boolean[] visited = new boolean[n];
    LinkedList<Integer> queue = new LinkedList<>();
    visited[0] = true;
    queue.addFirst(0);
    while (!queue.isEmpty()) {
      int current = queue.pollLast();
      for (int next : rooms.get(current)) {
        if (visited[next])
          continue;
        queue.addFirst(next);
        visited[next] = true;
        count++;
        if (count == n)
          return true;
      }
    }
    return false;
  }
}
// @lc code=end
