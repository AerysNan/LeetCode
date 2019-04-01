/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24点游戏
 *
 * https://leetcode-cn.com/problems/24-game/description/
 *
 * algorithms
 * Hard (35.47%)
 * Total Accepted:    445
 * Total Submissions: 1.3K
 * Testcase Example:  '[4,1,8,7]'
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 *
 *
 * 示例 2:
 *
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 *
 *
 * 注意:
 *
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1
 * 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 *
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
