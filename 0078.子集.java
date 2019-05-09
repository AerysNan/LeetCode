import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
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
