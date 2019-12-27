/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    int xor = Arrays.stream(nums).reduce((x, y) -> x ^ y).getAsInt();
    xor &= -xor;
    for (int num : nums) {
      if ((num & xor) == 0)
        result[0] ^= num;
      else
        result[1] ^= num;
    }
    return result;
  }
}
// @lc code=end

