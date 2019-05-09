import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    ArrayList<Integer> result = new ArrayList<>();
    result.add(nums[0]);
    int value = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == value)
        continue;
      result.add(nums[i]);
      value = nums[i];
    }
    for (int i = 0; i < result.size(); i++)
      nums[i] = result.get(i);
    return result.size();
  }
}
