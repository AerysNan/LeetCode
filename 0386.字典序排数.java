/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> res = new ArrayList<>();
    helper(res, 0, n);
    return res;
  }

  private void helper(List<Integer> result, int current, int n) {
    for (int i = 0; i < 10 && current <= n; i++, current++) {
      if (current == 0)
        continue;
      result.add(current);
      helper(result, current * 10, n);
    }
  }
}
// @lc code=end

