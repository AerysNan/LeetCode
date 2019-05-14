/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */
class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    int[] num = new int[1001];
    for (int i = 0; i < trips.length; i++) {
      num[trips[i][1]] += trips[i][0];
      num[trips[i][2]] -= trips[i][0];
    }
    int acc = 0;
    for (int i = 0; i <= 1000; i++) {
      acc += num[i];
      if (acc > capacity)
        return false;
    }
    return true;
  }
}