/*
 * @lc app=leetcode.cn id=5368 lang=java
 *
 * [5368] 找出数组中的幸运数
 */

// @lc code=start
class Solution {
  public int findLucky(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int v : arr)
      map.put(v, map.getOrDefault(v, 0) + 1);
    int result = -1;
    for (int k : map.keySet())
      if (k == map.get(k))
        result = Math.max(result, k);
    return result;
  }
}
// @lc code=end

