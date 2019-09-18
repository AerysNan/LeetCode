/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    if (n == 0)
      return result;
    boolean[] pick = new boolean[n];
    dfs(nums, pick, 0, new LinkedList<>());
    return result;
  }

  void dfs(int[] nums, boolean[] pick, int index, LinkedList<Integer> current) {
    if (index == nums.length) {
      result.add(new LinkedList<>(current));
      return;
    }
    dfs(nums, pick, index + 1, current);
    if (index > 0 && nums[index - 1] == nums[index] && !pick[index - 1])
      return;
    pick[index] = true;
    current.addLast(nums[index]);
    dfs(nums, pick, index + 1, current);
    current.pollLast();
    pick[index] = false;
  }
}
// @lc code=end

