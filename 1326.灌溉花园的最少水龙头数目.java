/*
 * @lc app=leetcode.cn id=1326 lang=java
 *
 * [1326] 灌溉花园的最少水龙头数目
 */

// @lc code=start
class Solution {
  public int minTaps(int n, int[] ranges) {
    int[] intervals = new int[n];
    for (int i = 0; i <= n; i++) {
      int l = Math.max(0, i - ranges[i]), r = Math.min(n, i + ranges[i]);
      if (l == r)
        continue;
      intervals[l] = Math.max(intervals[l], r);
    }
    int index = 0, furthest = 0, result = 0;
    while (furthest < n) {
      if (index > furthest)
        return -1;
      int next = Integer.MIN_VALUE;
      while (index < n && index <= furthest)
        next = Math.max(next, intervals[index++]);
      furthest = next;
      result++;
    }
    return result;
  }
}
// @lc code=end

