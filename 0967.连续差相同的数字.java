/*
 * @lc app=leetcode.cn id=967 lang=java
 *
 * [967] 连续差相同的数字
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> result = new ArrayList<>();

  public int[] numsSameConsecDiff(int n, int k) {
    for (int i = 1; i <= 9; i++)
      search(i, i, 1, n, k);
    return result.stream().mapToInt(x -> x).toArray();
  }

  void search(int value, int current, int digit, int n, int k) {
    if (digit == n) {
      result.add(value);
      return;
    }
    if (current - k >= 0)
      search(value * 10 + current - k, current - k, digit + 1, n, k);
    if (k != 0 && current + k <= 9)
      search(value * 10 + current + k, current + k, digit + 1, n, k);
  }
}
// @lc code=end
