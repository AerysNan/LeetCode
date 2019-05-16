import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1090 lang=java
 *
 * [1090] 受标签影响的最大值
 */
class Solution {
  public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    int n = values.length;
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(labels[i])) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>() {
          public int compare(Integer i1, Integer i2) {
            return i2 - i1;
          }
        });
        queue.add(values[i]);
        map.put(labels[i], queue);
      } else
        map.get(labels[i]).add(values[i]);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>() {
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    for (PriorityQueue<Integer> q : map.values()) {
      for (int i = 0; i < use_limit; i++) {
        if (q.isEmpty())
          break;
        queue.add(q.poll());
      }
    }
    int result = 0;
    for (int i = 0; i < num_wanted; i++) {
      if (queue.isEmpty())
        break;
      result += queue.poll();
    }
    return result;
  }
}
