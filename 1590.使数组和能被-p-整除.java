/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除
 */

// @lc code=start
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
  HashMap<Integer, TreeSet<Integer>> map = new HashMap<>(), sub = new HashMap<>();

  public int minSubarray(int[] nums, int p) {
    int n = nums.length;
    int[] sum = new int[n + 1];
    for (int i = 1; i <= n; i++)
      sum[i] = (sum[i - 1] + nums[i - 1]) % p;
    for (int i = 0; i <= n; i++) {
      map.computeIfAbsent((sum[i] + sum[n]) % p, x -> new TreeSet<>()).add(i);
      sub.computeIfAbsent(sum[i], x -> new TreeSet<>()).add(i);
    }
    if (sum[n] == 0)
      return 0;
    int result = Integer.MAX_VALUE;
    for (int key : map.keySet()) {
      if (!sub.containsKey(key))
        continue;
      TreeSet<Integer> set = map.get(key);
      for (int value : set) {
        Integer next = sub.get(key).ceiling(value);
        if (next != null)
          result = Math.min(result, next - value);
      }
    }
    return result == n ? -1 : result;
  }
}
// @lc code=end
