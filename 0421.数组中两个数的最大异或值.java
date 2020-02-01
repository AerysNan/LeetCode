/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public int findMaximumXOR(int[] nums) {
    int result = 0, mask = 0;
    for (int i = 31; i >= 0; i--) {
      mask = mask | (1 << i);
      HashSet<Integer> set = new HashSet<Integer>();
      for (int num : nums)
        set.add(mask & num);
      int temp = result | (1 << i);
      for (int prefix : set)
        if (set.contains(prefix ^ temp))
          result = temp;
    }
    return result;
  }
}
// @lc code=end

