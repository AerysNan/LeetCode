/*
 * @lc app=leetcode.cn id=1589 lang=java
 *
 * [1589] 所有排列中的最大和
 */

// @lc code=start
class Solution {
  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    int n = nums.length;
    int[] diff = new int[n + 1];
    for (int[] request : requests) {
      diff[request[0]]++;
      diff[request[1] + 1]--;
    }
    int[] acc = new int[n];
    acc[0] = diff[0];
    for (int i = 1; i < n; i++)
      acc[i] = acc[i - 1] + diff[i];
    Arrays.sort(nums);
    Arrays.sort(acc);
    long result = 0;
    for (int i = 0; i < n; i++)
      result = (result + nums[i] * acc[i]) % 1000000007;
    return (int) result;
  }
}
// @lc code=end
