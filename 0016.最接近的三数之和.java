import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int minDiff = Integer.MAX_VALUE;
    int n = nums.length;
    Arrays.sort(nums);
    for (int index = 0; index < n - 2; index++) {
      int left = index + 1, right = n - 1;
      while (left < right) {
        int diff = nums[index] + nums[left] + nums[right] - target;
        if (Math.abs(minDiff) > Math.abs(diff))
          minDiff = diff;
        if (diff == 0)
          return target;
        if (diff > 0)
          right--;
        else
          left++;
      }
    }
    return minDiff + target;
  }
}
