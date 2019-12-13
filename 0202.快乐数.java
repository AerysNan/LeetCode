/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    set.add(n);
    int number = n;
    while (true) {
      int value = 0;
      while (number > 0) {
        value += (number % 10) * (number % 10);
        number /= 10;
      }
      if (value == 1)
        return true;
      if (set.contains(value))
        return false;
      number = value;
      set.add(value);
    }
  }
}
// @lc code=end

