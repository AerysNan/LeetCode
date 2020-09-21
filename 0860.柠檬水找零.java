/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
  public boolean lemonadeChange(int[] bills) {
    int[] count = new int[2];
    for (int bill : bills) {
      if (bill == 5)
        count[0]++;
      else if (bill == 10) {
        if (count[0] == 0)
          return false;
        count[0]--;
        count[1]++;
      } else {
        if (count[1] > 0 && count[0] > 0) {
          count[1]--;
          count[0]--;
        } else if (count[0] > 2)
          count[0] -= 3;
        else
          return false;
      }
    }
    return true;
  }
}
// @lc code=end
