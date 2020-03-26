/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int d : deck)
      map.put(d, map.getOrDefault(d, 0) + 1);
    return map.values().stream().reduce((x, y) -> gcd(x, y)).get() >= 2;
  }

  int gcd(int a, int b) {
    return a % b == 0 ? b : gcd(b, a % b);

  }
}
// @lc code=end

