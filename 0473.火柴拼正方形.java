/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public HashMap<Pair<Integer, Integer>, Boolean> m;
  public int[] nums;
  public int length;

  public Solution() {
    m = new HashMap<>();
  }

  public boolean recurse(int mask, int sides) {
    int total = 0, n = nums.length;
    Pair<Integer, Integer> key = new Pair<>(mask, sides);
    if (m.containsKey(key))
      return m.get(key);
    for (int i = n - 1; i >= 0; i--)
      if ((mask & (1 << i)) == 0)
        total += nums[n - 1 - i];
    if (total > 0 && total % length == 0)
      sides++;
    if (sides == 3)
      return true;
    boolean result = false;
    int finished = total / length, remain = length * (finished + 1) - total;
    for (int i = n - 1; i >= 0; i--) {
      if (nums[n - 1 - i] <= remain && (mask & (1 << i)) > 0) {
        if (recurse(mask ^ (1 << i), sides)) {
          result = true;
          break;
        }
      }
    }
    m.put(key, result);
    return result;
  }

  public boolean makesquare(int[] nums) {
    if (nums == null || nums.length == 0)
      return false;
    int n = nums.length, perimeter = Arrays.stream(nums).sum(), length = perimeter / 4;
    if (length * 4 != perimeter)
      return false;
    this.nums = nums;
    this.length = length;
    return recurse((1 << n) - 1, 0);
  }
}
// @lc code=end

