import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (71.26%)
 * Total Accepted:    12.8K
 * Total Submissions: 18K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
class Solution {
  private List<List<Integer>> result;
  private LinkedList<Integer> current;

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    if (nums.length == 0)
      return result;
    current = new LinkedList<>();
    search(nums, 0);
    return result;
  }

  private void search(int[] nums, int index) {
    if (index == nums.length) {
      result.add((LinkedList<Integer>) current.clone());
      return;
    }
    search(nums, index + 1);
    current.addLast(nums[index]);
    search(nums, index + 1);
    current.removeLast();
  }
}
