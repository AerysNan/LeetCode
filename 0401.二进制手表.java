/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<String>();
    for (int x = 0; x < 12; x++) {
      for (int y = 0; y < 60; y++) {
        if (Integer.bitCount(x) + Integer.bitCount(y) == num) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Integer.toString(x));
          stringBuilder.append(":");
          stringBuilder.append(((y < 10) ? "0" : "") + Integer.toString(y));
          times.add(stringBuilder.toString());
        }
      }
    }
    return times;
  }
}
// @lc code=end

