/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */
class Solution {
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] record = new int[n];
    for (int[] info : bookings) {
      record[info[0] - 1] += info[2];
      if (info[1] < n)
        record[info[1]] -= info[2];
    }
    for (int i = 1; i < n; i++)
      record[i] += record[i - 1];
    return record;
  }
}
