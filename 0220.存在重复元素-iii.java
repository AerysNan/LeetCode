/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
import java.util.SortedSet;
import java.util.TreeSet;

class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k)
        set.remove((long) nums[i - k - 1]);
      SortedSet<Long> subSet = set.tailSet((long) nums[i] - t);
      if (!subSet.isEmpty() && subSet.first() - nums[i] <= t)
        return true;
      set.add((long) nums[i]);
    }
    return false;
  }
}
// @lc code=end

