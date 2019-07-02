import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */
class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    for (int s : stones)
      queue.add(s);
    while (queue.size() >= 2) {
      int s1 = queue.poll();
      int s2 = queue.poll();
      if (s1 != s2)
        queue.add(Math.abs(s1 - s2));
    }
    if (queue.isEmpty())
      return 0;
    return queue.poll();
  }
}
