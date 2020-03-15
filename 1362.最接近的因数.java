/*
 * @lc app=leetcode.cn id=1362 lang=java
 *
 * [1362] 最接近的因数
 */

// @lc code=start
class Solution {
  public int[] closestDivisors(int num) {
    int[] result = new int[] {0, (int) 1e9};
    int mul = num + 1;
    for (int i = (int) Math.sqrt((double) mul); i > 0; i--) {
      if (mul % i == 0 && mul / i - i < result[1] - result[0]) {
        result[0] = i;
        result[1] = mul / i;
      }
    }
    mul = num + 2;
    for (int i = (int) Math.sqrt((double) mul); i > 0; i--) {
      if (mul % i == 0 && mul / i - i < result[1] - result[0]) {
        result[0] = i;
        result[1] = mul / i;
      }
    }
    return result;
  }
}
// @lc code=end

