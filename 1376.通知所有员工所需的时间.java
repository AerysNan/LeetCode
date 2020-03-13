/*
 * @lc app=leetcode.cn id=1376 lang=java
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start
class Solution {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Integer[] time = new Integer[n];
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
      result = Math.max(result, getTime(i, time, manager, informTime));
    return result;
  }

  int getTime(int id, Integer[] time, int[] manager, int[] informTime) {
    int m = manager[id];
    if (m == -1)
      return 0;
    if (time[m] != null)
      time[id] = time[m] + informTime[m];
    else
      time[id] = getTime(m, time, manager, informTime) + informTime[m];
    return time[id];
  }
}
// @lc code=end

