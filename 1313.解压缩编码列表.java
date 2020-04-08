/*
 * @lc app=leetcode.cn id=1313 lang=java
 *
 * [1313] 解压缩编码列表
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int[] decompressRLElist(int[] nums) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i += 2)
      for (int j = 0; j < nums[i]; j++)
        result.add(nums[i + 1]);
    return result.stream().mapToInt(i -> i).toArray();
  }
}
// @lc code=end

