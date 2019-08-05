import java.util.Date;

/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */
class Solution {
  int[] acc = { 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

  public int dayOfYear(String date) {
    int y = Integer.parseInt(date.substring(0, 4));
    int m = Integer.parseInt(date.substring(5, 7));
    int d = Integer.parseInt(date.substring(8, 10));
    int result = m == 1 ? 0 : acc[m - 2];
    if (m > 2 && isLeap(y))
      result++;
    return result + d;
  }

  private boolean isLeap(int y) {
    return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
  }
}
