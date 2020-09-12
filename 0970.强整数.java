/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    HashSet<Integer> result = new HashSet<>();
    if (x == 1 && y == 1) {
      if (bound >= 2)
        result.add(2);
    } else if (x == 1) {
      for (int i = 1; i <= bound - 1; i *= y)
        result.add(i + 1);
    } else if (y == 1) {
      for (int i = 1; i <= bound - 1; i *= x)
        result.add(i + 1);
    } else {
      for (int i = 1; i < bound; i *= x)
        for (int j = 1; j <= bound - i; j *= y)
          result.add(i + j);
    }
    return new ArrayList<>(result);
  }
}
// @lc code=end
