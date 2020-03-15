/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
  public int daysBetweenDates(String date1, String date2) {
    LocalDate startDate = LocalDate.parse(date1);
    LocalDate endDate = LocalDate.parse(date2);
    long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
    return Math.abs((int) daysDiff);
  }
}
// @lc code=end

