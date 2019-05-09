/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24点游戏
 */
class Solution {
  public boolean judgePoint24(int[] nums) {
    double[] array = new double[nums.length];
    for (int i = 0; i < nums.length; i++)
      array[i] = (double) nums[i];
    return search(array);
  }

  private boolean search(double[] nums) {
    int n = nums.length;
    if (n == 1)
      return Math.abs(nums[0] - 24) < 1e-5;
    double[] newNums = new double[n - 1];
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double[] newValues = calculate(nums[i], nums[j]);
        int index = 0;
        for (int k = 0; k < n; k++)
          if (k != i && k != j)
            newNums[index++] = nums[k];
        for (double num : newValues) {
          newNums[n - 2] = num;
          if (search(newNums))
            return true;
        }
      }
    }
    return false;
  }

  private double[] calculate(double x, double y) {
    return new double[] { x + y, x - y, y - x, x * y, x / y, y / x };
  }
}
