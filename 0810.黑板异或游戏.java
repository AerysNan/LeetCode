import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=810 lang=java
 *
 * [810] 黑板异或游戏
 */

// @lc code=start
class Solution {
  public boolean xorGame(int[] nums) {
    return Arrays.stream(nums).reduce((x, y) -> x ^ y).getAsInt() == 0 || nums.length % 2 == 0;
  }
}
// @lc code=end
