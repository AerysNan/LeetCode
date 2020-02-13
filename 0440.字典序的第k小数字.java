/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 */

// @lc code=start
class Solution {
  public int findKthNumber(int n, int k) {
    int result = 1;
    k--;
    while (k > 0) {
      long left = result, right = result + 1;
      int count = 0;
      while (left <= n) {
        count += Math.min(right, (long) (n + 1)) - left;
        left *= 10;
        right *= 10;
      }
      if (count <= k) {
        k -= count;
        result++;
      } else {
        k--;
        result *= 10;
      }
    }
    return result;
  }
}
// @lc code=end

