/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public void wiggleSort(int[] nums) {
    int[] tmp = nums.clone();
    Arrays.sort(tmp);
    int p = (nums.length + 1) / 2, q = nums.length;
    for (int i = 0; i < nums.length; i++)
      nums[i] = i % 2 == 1 ? tmp[--q] : tmp[--p];
  }
}
// @lc code=end

