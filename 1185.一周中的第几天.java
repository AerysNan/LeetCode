/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
import java.util.Calendar;
import java.util.Date;

class Solution {
  String[] table =
      new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

  public String dayOfTheWeek(int day, int month, int year) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month - 1, day);
    return table[calendar.get(Calendar.DAY_OF_WEEK) - 1];
  }
}
// @lc code=end

