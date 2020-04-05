/*
 * @lc app=leetcode.cn id=5364 lang=java
 *
 * [5364] 按既定顺序创建目标数组
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int[] createTargetArray(int[] nums, int[] index) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++)
      list.add(index[i], nums[i]);
    return list.stream().mapToInt(i -> i).toArray();
  }
}
// @lc code=end

