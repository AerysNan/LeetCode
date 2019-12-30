import java.util.Random;

/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {
  int[] nums;
  Random random;

  public Solution(int[] nums) {
    this.nums = nums;
    this.random = new Random();
  }

  public int pick(int target) {
    int index = -1, count = 1;
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == target && random.nextInt(count++) == 0)
        index = i;
    return index;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

