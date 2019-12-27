/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int value1 = 0, value2 = 1, count1 = 0, count2 = 0;
    for (int num : nums) {
      if (num == value1)
        count1++;
      else if (num == value2)
        count2++;
      else if (count1 == 0) {
        value1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        value2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    System.out.println(value1 + " " + value2);
    if (value1 == value2)
      return Arrays.asList(value1);
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (num == value1)
        count1++;
      if (num == value2)
        count2++;
    }
    if (count1 > nums.length / 3)
      result.add(value1);
    if (count2 > nums.length / 3)
      result.add(value2);
    return result;
  }
}
// @lc code=end

