/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> combinationSum3(int k, int n) {
    result = new ArrayList<>();
    solve(new LinkedList<>(), k, 1, n);
    return result;
  }

  void solve(LinkedList<Integer> current, int k, int index, int sum) {
    if (current.size() == k && sum == 0) {
      result.add(new LinkedList<>(current));
      return;
    }
    if (current.size() >= k)
      return;
    for (int i = index; i < 10; i++) {
      current.addLast(i);
      solve(current, k, i + 1, sum - i);
      current.pollLast();
    }
  }
}
// @lc code=end

