/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums, 0, new LinkedList<>(), result);
    return result;
  }

  void dfs(int[] nums, int index, LinkedList<Integer> current, List<List<Integer>> result) {
    if (current.size() >= 2)
      result.add(new ArrayList<>(current));
    HashSet<Integer> visited = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (!current.isEmpty() && current.getLast() > nums[i] || visited.contains(nums[i]))
        continue;
      current.addLast(nums[i]);
      visited.add(nums[i]);
      dfs(nums, i + 1, current, result);
      current.removeLast();
    }
  }
}
// @lc code=end

