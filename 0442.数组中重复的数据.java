/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i : nums) {
      int index = Math.abs(i) - 1;
      if (nums[index] < 0)
        result.add(index + 1);
      nums[index] = -nums[index];
    }
    return result;
  }
}
// @lc code=end

