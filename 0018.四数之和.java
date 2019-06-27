/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
class Solution {
  int n;

  public List<List<Integer>> fourSum(int[] nums, int target) {
    n = nums.length;
    Arrays.sort(nums);
    return kSum(nums, target, 4, 0);
  }

  private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    if (index >= n)
      return result;
    if (k == 2) {
      int i = index, j = n - 1;
      while (i < j) {
        if (target - nums[i] == nums[j]) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(target - nums[i]);
          result.add(temp);
          while (i < j && nums[i] == nums[i + 1])
            i++;
          while (i < j && nums[j - 1] == nums[j])
            j--;
          i++;
          j--;
        } else if (target - nums[i] > nums[j])
          i++;
        else
          j--;
      }
    } else {
      for (int i = index; i < n - k + 1; i++) {
        ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
        if (temp != null) {
          for (List<Integer> t : temp)
            t.add(0, nums[i]);
          result.addAll(temp);
        }
        while (i < n - 1 && nums[i] == nums[i + 1])
          i++;
      }
    }
    return result;
  }
}
