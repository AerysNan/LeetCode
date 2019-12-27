/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    int n = nums.length;
    if (n == 0)
      return result;
    int l = 0;
    while (l < n) {
      int r = l;
      while (r + 1 < n && nums[r] + 1 == nums[r + 1])
        r++;
      result.add(l == r ? String.valueOf(nums[l]) : nums[l] + "->" + nums[r]);
      l = r + 1;
    }
    return result;
  }
}
// @lc code=end

