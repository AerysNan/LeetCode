/*
 * @lc app=leetcode.cn id=5348 lang=java
 *
 * [5348] 两个数组间的距离值
 */

// @lc code=start
class Solution {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int result = 0;
    for (int v1 : arr1) {
      boolean valid = true;
      for (int v2 : arr2)
        if (Math.abs(v1 - v2) <= d) {
          valid = false;
          break;
        }
      if (valid)
        result++;
    }
    return result;
  }
}
// @lc code=end

