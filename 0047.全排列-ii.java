/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> result;
  List<Integer> current;

  public List<List<Integer>> permuteUnique(int[] nums) {
    result = new ArrayList<>();
    current = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    run(nums, 0, used);
    return result;
  }

  void run(int[] nums, int index, boolean[] used) {
    int n = nums.length;
    if (index == n)
      result.add(new LinkedList<>(current));
    HashSet<Integer> dup = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (used[i] || dup.contains(nums[i]))
        continue;
      used[i] = true;
      dup.add(nums[i]);
      current.add(nums[i]);
      run(nums, index + 1, used);
      used[i] = false;
      current.remove(index);
    }
  }
}
// @lc code=end
