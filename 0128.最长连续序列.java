import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (41.86%)
 * Total Accepted:    5.2K
 * Total Submissions: 12.3K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
class Solution {
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int num : nums) {
      if (map.containsKey(num))
        continue;
      int l = map.containsKey(num - 1) ? map.get(num - 1) : 0;
      int r = map.containsKey(num + 1) ? map.get(num + 1) : 0;
      int length = l + r + 1;
      map.put(num, length);
      result = Math.max(result, length);
      map.put(num - l, length);
      map.put(num + r, length);
    }
    return result;
  }
}
