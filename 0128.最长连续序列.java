import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
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
