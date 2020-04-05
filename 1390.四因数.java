/*
 * @lc app=leetcode.cn id=5178 lang=java
 *
 * [5178] 四因数
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int sumFourDivisors(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      ArrayList<Integer> list = getDivisors(num);
      if (list != null && list.size() == 4)
        sum += list.stream().reduce(0, (x, y) -> (x + y));
    }
    return sum;
  }

  ArrayList<Integer> getDivisors(int num) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = (int) Math.sqrt(num);
    if (n * n == num)
      return null;
    for (int i = 1; i <= n; i++) {
      if (num % i == 0) {
        result.add(i);
        result.add(num / i);
        if (result.size() > 4)
          return null;
      }
    }
    return result;
  }
}
// @lc code=end

