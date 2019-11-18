import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0)
      return "";
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++)
      strs[i] = String.valueOf(nums[i]);
    Arrays.sort(strs, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1);
      }
    });
    if (strs[strs.length - 1].charAt(0) == '0')
      return "0";
    String result = "";
    for (String str : strs)
      result = str + result;
    return result;
  }
}
// @lc code=end

