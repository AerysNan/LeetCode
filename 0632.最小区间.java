import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

/*
 * @lc app=leetcode.cn id=632 lang=java
 *
 * [632] 最小区间
 */
class Solution {

  class Triad {
    int row, column, value;

    Triad(int row, int column, int value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }
  }

  public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<Triad> queue = new PriorityQueue<>(new Comparator<Triad>() {
      @Override
      public int compare(Triad t1, Triad t2) {
        return t1.value - t2.value;
      }
    });
    int begin = Integer.MAX_VALUE, end = Integer.MIN_VALUE, length = Integer.MAX_VALUE;
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> list = nums.get(i);
      Triad t = new Triad(i, 0, list.get(0));
      queue.add(t);
      end = Math.max(end, list.get(0));
    }
    while (queue.size() == nums.size()) {
      Triad t = queue.poll();
      if (end - t.value < length) {
        length = end - t.value;
        begin = t.value;
        System.out.println(length);
      }
      if (t.column < nums.get(t.row).size() - 1) {
        t.column++;
        t.value = nums.get(t.row).get(t.column);
        queue.add(t);
        end = Math.max(end, t.value);
      }
    }
    return new int[] { begin, begin + length };
  }
}
