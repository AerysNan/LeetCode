import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
  public boolean canPartition(int[] nums) {
    int total = Arrays.stream(nums).reduce(0, (x, y) -> x + y);
    if (total % 2 != 0)
      return false;
    int sum = total / 2;
    int[][] mem = new int[nums.length][sum];
    return dp(sum, 0, 0, nums, mem);
  }

  public boolean dp(int sum, int current, int index, int[] nums, int[][] mem) {
    if (current > sum || index >= nums.length)
      return false;
    if (current == sum)
      return true;
    if (mem[index][current] > 0)
      return mem[index][current] == 1;
    boolean result = dp(sum, current + nums[index], index + 1, nums, mem)
        || dp(sum, current, index + 1, nums, mem);
    mem[index][current] = result ? 1 : 2;
    return result;
  }
}
// @lc code=end

