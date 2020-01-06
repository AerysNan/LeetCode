/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : nums)
      map.put(n, map.getOrDefault(n, 0) + 1);
    List<Integer>[] bucket = new List[nums.length + 1];
    for (int n : map.keySet()) {
      int freq = map.get(n);
      if (bucket[freq] == null)
        bucket[freq] = new LinkedList<>();
      bucket[freq].add(n);
    }
    List<Integer> result = new LinkedList<>();
    for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
      if (bucket[i] == null)
        continue;
      List<Integer> list = bucket[i];
      result.addAll(list);
      k -= list.size();
    }
    return result;
  }
}
// @lc code=end

