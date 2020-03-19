/*
 * @lc app=leetcode.cn id=1346 lang=java
 *
 * [1346] 检查整数及其两倍数是否存在
 */

// @lc code=start
import java.util.HashSet;

class Solution {
  public boolean checkIfExist(int[] arr) {
    int zero = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int a : arr) {
      if (a == 0)
        zero++;
      set.add(a);
    }
    for (int a : arr)
      if (a != 0 && set.contains(a * 2))
        return true;
    return zero >= 2;
  }
}
// @lc code=end

