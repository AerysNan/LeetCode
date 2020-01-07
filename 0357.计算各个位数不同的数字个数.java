/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {

  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0)
      return 1;
    int sum = 10, add = 9;
    for (int i = 1; i < n; i++) {
      sum += add * (10 - i);
      add *= (10 - i);
    }
    return sum;
  }
}
// @lc code=end

