/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */

// @lc code=start
class Solution {
  public int[] sumZero(int n) {
    int[] result = new int[n];
    if (n % 2 != 0)
      result[--n] = 0;
    for (int i = 0; i < n; i += 2) {
      result[i] = i + 1;
      result[i + 1] = -i - 1;
    }
    return result;
  }
}
// @lc code=end
