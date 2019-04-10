import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

/*
 * @lc app=leetcode.cn id=632 lang=java
 *
 * [632] 最小区间
 *
 * https://leetcode-cn.com/problems/smallest-range/description/
 *
 * algorithms
 * Hard (38.10%)
 * Total Accepted:    237
 * Total Submissions: 622
 * Testcase Example:  '[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]'
 *
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 示例 1:
 *
 *
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 *
 * 注意:
 *
 *
 * 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
 * 1 <= k <= 3500
 * -10^5 <= 元素的值 <= 10^5
 * 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
 *
 *
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
