import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
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
