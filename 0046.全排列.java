import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (66.75%)
 * Total Accepted:    16.6K
 * Total Submissions: 24.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
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
