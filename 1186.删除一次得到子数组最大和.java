/*
 * @lc app=leetcode.cn id=1186 lang=java
 *
 * [1186] 删除一次得到子数组最大和
 */

// @lc code=start
class Solution {
  public int maximumSum(int[] arr) {
    int n = arr.length, dp_nop = arr[0], dp_del = 0, result = arr[0];
    for (int i = 1; i < n; i++) {
      dp_del = Math.max(dp_del + arr[i], dp_nop);
      dp_nop = Math.max(dp_nop + arr[i], arr[i]);
      result = Math.max(result, Math.max(dp_del, dp_nop));
    }
    return result;
  }
}
// @lc code=end

