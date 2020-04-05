/*
 * @lc app=leetcode.cn id=5349 lang=java
 *
 * [5349] 安排电影院座位
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
    for (int[] seat : reservedSeats) {
      if (!m.containsKey(seat[0]))
        m.put(seat[0], new ArrayList<>());
      m.get(seat[0]).add(seat[1] - 1);
    }
    int result = 2 * n - 2 * m.size();
    for (ArrayList<Integer> list : m.values()) {
      boolean[] invalid = new boolean[10];
      for (int v : list)
        invalid[v] = true;
      int index = 0, count = 0;
      while (index < 10) {
        if (invalid[index])
          count = 0;
        else {
          count++;
          System.out.println(count + " " + index);
          if (count >= 4 && index != 3 && index != 5 && index != 7 && index != 9) {
            result++;
            count = 0;
          }
        }
        index++;
      }
    }
    return result;
  }
}
// @lc code=end

