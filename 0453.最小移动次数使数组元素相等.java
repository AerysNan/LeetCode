/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int minMoves(int[] nums) {
    int sum = Arrays.stream(nums).reduce(0, (x, y) -> x + y);;
    int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (x, y) -> Integer.min(x, y));
    return sum - min * nums.length;
  }
}
// @lc code=end

