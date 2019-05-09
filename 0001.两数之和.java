/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] stash = new int[nums.length];
    for (int i = 0; i < nums.length; i++)
      stash[i] = nums[i];
    Arrays.sort(nums);
    int[] result = new int[2];
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int sum = nums[low] + nums[high];
      if (sum == target) {
        for (int i = 0; i < stash.length; i++) {
          if (stash[i] == nums[low]) {
            result[0] = i;
            break;
          }
        }
        for (int i = 0; i < stash.length; i++) {
          if (stash[i] == nums[high]) {
            if (i == result[0])
              continue;
            result[1] = i;
            break;
          }
        }
        return result;
      } else if (sum < target)
        low++;
      else
        high--;
    }
    return result;
  }
}
