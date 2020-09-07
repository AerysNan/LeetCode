/*
 * @lc app=leetcode.cn id=822 lang=java
 *
 * [822] 翻转卡片游戏
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int flipgame(int[] fronts, int[] backs) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < fronts.length; ++i)
      if (fronts[i] == backs[i])
        set.add(fronts[i]);
    int result = Integer.MAX_VALUE;
    for (int x : fronts)
      if (!set.contains(x))
        result = Math.min(result, x);
    for (int x : backs)
      if (!set.contains(x))
        result = Math.min(result, x);
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
// @lc code=end
