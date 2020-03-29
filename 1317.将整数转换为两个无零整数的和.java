/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
  public int[] getNoZeroIntegers(int n) {
    for (int i = 1; i < n; i++)
      if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0"))
        return new int[] {i, n - i};
    return null;
  }
}
// @lc code=end

