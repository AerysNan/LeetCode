/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 *
 * https://leetcode-cn.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (34.13%)
 * Total Accepted:    739
 * Total Submissions: 2.2K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 *
 *
 * 示例:
 *
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 *
 */
class Solution {
  public int splitArray(int[] nums, int m) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int l = max, h = sum;
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (valid(mid, nums, m))
        h = mid - 1;
      else
        l = mid + 1;
    }
    return l;
  }

  private boolean valid(int target, int[] nums, int m) {
    int sum = 0, count = 1;
    for (int num : nums) {
      if (sum + num > target) {
        sum = num;
        count++;
      } else
        sum += num;
    }
    return count <= m;
  }
}
