/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
  int[] prefix;

  public NumArray(int[] nums) {
    int n = nums.length;
    prefix = new int[n + 1];
    for (int i = 1; i <= n; i++)
      prefix[i] = prefix[i - 1] + nums[i - 1];
  }

  public int sumRange(int i, int j) {
    return prefix[j + 1] - prefix[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

