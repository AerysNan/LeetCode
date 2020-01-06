/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>(), result = new HashSet<>();
    for (int num : nums1)
      set.add(num);
    for (int num : nums2)
      if (set.contains(num))
        result.add(num);
    int index = 0;
    int[] list = new int[result.size()];
    Iterator<Integer> iterator = result.iterator();
    while (iterator.hasNext())
      list[index++] = iterator.next();
    return list;
  }
}
// @lc code=end

