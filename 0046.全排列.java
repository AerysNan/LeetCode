import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */
class Solution {
  private boolean[] mark;

  private List<List<Integer>> result;

  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
    mark = new boolean[n];
    result = new ArrayList<>();
    LinkedList<Integer> helper = new LinkedList<>();
    dfs(nums, helper, 0);
    return result;
  }

  private void dfs(int[] nums, LinkedList<Integer> helper, int n) {
    if (n == nums.length)
      result.add(new LinkedList<Integer>(helper));
    for (int i = 0; i < nums.length; i++) {
      if (mark[i])
        continue;
      mark[i] = true;
      helper.addLast(nums[i]);
      dfs(nums, helper, n + 1);
      helper.removeLast();
      mark[i] = false;
    }
  }
}
