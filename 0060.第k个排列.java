/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
  public String getPermutation(int n, int k) {
    if (n == 0)
      return "";
    LinkedList<Integer> numbers = new LinkedList<>();
    for (int i = 1; i <= n; i++)
      numbers.add(i);
    int[] factor = new int[n];
    factor[0] = 1;
    for (int i = 1; i < n; i++)
      factor[i] = i * factor[i - 1];
    StringBuilder sb = new StringBuilder();
    k--;
    for (int i = 1; i <= n; i++) {
      int index = k / factor[n - i];
      k %= factor[n - i];
      sb.append(numbers.get(index));
      numbers.remove(index);
    }
    return sb.toString();
  }
}
// @lc code=end
