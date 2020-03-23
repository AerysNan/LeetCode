/*
 * @lc app=leetcode.cn id=1338 lang=java
 *
 * [1338] 数组大小减半
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int minSetSize(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int a : arr)
      map.put(a, map.getOrDefault(a, 0) + 1);
    ArrayList<int[]> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> e : map.entrySet())
      list.add(new int[] {e.getKey(), e.getValue()});
    list.sort(new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return i2[1] - i1[1];
      }
    });
    int target = (arr.length + 1) / 2, result = 0;
    for (int[] p : list) {
      target -= p[1];
      result++;
      if (target <= 0)
        break;
    }
    return result;
  }
}

// @lc code=end

