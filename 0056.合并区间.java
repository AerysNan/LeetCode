/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0)
      return new int[][] {};
    ArrayList<int[]> result = new ArrayList<>();
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });
    int[] current = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] <= current[1])
        current[1] = Math.max(current[1], interval[1]);
      else {
        result.add(current);
        current = interval;
      }
    }
    result.add(current);
    int[][] output = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++)
      output[i] = result.get(i);
    return output;
  }
}
// @lc code=end
