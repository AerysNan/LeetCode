/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public boolean canCross(int[] stones) {
    HashMap<Integer, Boolean> map = new HashMap<>();
    return solve(stones, 0, 0, map);
  }

  boolean solve(int[] stones, int index, int leap, HashMap<Integer, Boolean> map) {
    int n = stones.length;
    if (index == n - 1)
      return true;
    int key = leap << 11 | index;
    if (map.containsKey(key))
      return map.get(key);
    for (int i = index + 1; i < n; i++) {
      int distance = stones[i] - stones[index];
      if (distance < leap - 1)
        continue;
      if (distance > leap + 1) {
        map.put(key, false);
        return false;
      }
      if (solve(stones, i, distance, map)) {
        map.put(key, true);
        return true;
      }
    }
    map.put(key, false);
    return false;
  }
}
// @lc code=end

