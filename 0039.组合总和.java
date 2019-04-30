import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (63.02%)
 * Total Accepted:    13K
 * Total Submissions: 20.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 *
 *
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 */
class Solution {
  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    result = new ArrayList<>();
    search(new LinkedList<>(), candidates, target, 0);
    return result;
  }

  private void search(LinkedList<Integer> list, int[] candidates, int target, int pos) {
    if (target < 0)
      return;
    if (target == 0)
      result.add(new LinkedList<Integer>(list));
    for (int i = pos; i < candidates.length; i++) {
      list.add(candidates[i]);
      search(list, candidates, target - candidates[i], i);
      list.removeLast();
    }
  }
}
