/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length == 0)
      return 0;
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] v1, int[] v2) {
        return Integer.compare(v1[1], v2[1]);
      }
    });
    int result = 1, prev = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= intervals[prev][1]) {
        result++;
        prev = i;
      }
    }
    return intervals.length - result;
  }
}
// @lc code=end

