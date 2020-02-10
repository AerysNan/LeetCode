/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
import java.util.Map;
import java.util.TreeMap;

class Solution {
  public int[] findRightInterval(int[][] intervals) {
    int[] result = new int[intervals.length];
    TreeMap<Integer, Integer> intervalMap = new TreeMap<>();
    for (int i = 0; i < intervals.length; ++i)
      intervalMap.put(intervals[i][0], i);
    for (int i = 0; i < intervals.length; ++i) {
      Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
      result[i] = (entry != null) ? entry.getValue() : -1;
    }
    return result;
  }
}
// @lc code=end

