/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i : nums) {
      int index = Math.abs(i) - 1;
      nums[index] = -Math.abs(nums[index]);
    }
    for (int i = 0; i < nums.length; i++)
      if (nums[i] > 0)
        result.add(i + 1);
    return result;
  }
}
// @lc code=end

