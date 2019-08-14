/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] cand, int remain, int start) {
    if (remain < 0)
      return;
    else if (remain == 0)
      list.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < cand.length; i++) {
        if (i > start && cand[i] == cand[i - 1])
          continue;
        tempList.add(cand[i]);
        backtrack(list, tempList, cand, remain - cand[i], i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
// @lc code=end
