/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> combine(int n, int k) {
    result = new ArrayList<>();
    if (n == 0 || k == 0)
      return result;
    choose(new LinkedList<>(), 1, n, k);
    return result;
  }

  void choose(LinkedList<Integer> current, int l, int r, int k) {
    if (k == 0) {
      result.add(new LinkedList<>(current));
      return;
    }
    for (int i = l; i <= r - k + 1; i++) {
      current.addLast(i);
      choose(current, i + 1, r, k - 1);
      current.pollLast();
    }
  }
}
// @lc code=end

