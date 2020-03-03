/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  HashMap<Integer, Boolean> dp = new HashMap<>();

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (maxChoosableInteger >= desiredTotal)
      return true;
    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
      return false;
    return dfs(maxChoosableInteger, desiredTotal, 0);
  }

  boolean dfs(int max, int sum, int used) {
    if (dp.containsKey(used))
      return dp.get(used);
    for (int i = 1; i <= max; i++) {
      int mask = 1 << (i - 1);
      if ((mask & used) != 0)
        continue;
      if (sum <= i || !dfs(max, sum - i, used | mask)) {
        dp.put(used, true);
        return true;
      }
    }
    dp.put(used, false);
    return false;
  }
}
// @lc code=end

