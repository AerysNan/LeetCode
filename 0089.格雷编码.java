/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
  public List<Integer> grayCode(int n) {
    if (n == 0)
      return Arrays.asList(0);
    List<Integer> list = grayCode(n - 1);
    List<Integer> next = new ArrayList<Integer>(list);
    int pow = 1 << (n - 1);
    for (int i = list.size() - 1; i >= 0; i--)
      next.add(list.get(i) | pow);
    return next;
  }
}
// @lc code=end

