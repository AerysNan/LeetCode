import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 *
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (51.86%)
 * Total Accepted:    251
 * Total Submissions: 484
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 *
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 *
 *
 *
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 *
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

class SummaryRanges {
  private TreeMap<Integer, Interval> map;

  /** Initialize your data structure here. */
  public SummaryRanges() {
    map = new TreeMap<>();
  }

  public void addNum(int val) {
    if (map.containsKey(val))
      return;
    Integer l = map.lowerKey(val);
    Integer h = map.higherKey(val);
    if (l != null && map.get(l).start <= val && map.get(l).end >= val)
      return;
    if (l != null && h != null && map.get(l).end + 1 == val && map.get(h).start - 1 == val) {
      map.get(l).end = map.get(h).end;
      map.remove(h);
    } else if (l != null && map.get(l).end + 1 == val)
      map.get(l).end++;
    else if (h != null && map.get(h).start - 1 == val) {
      map.put(val, new Interval(val, map.get(h).end));
      map.remove(h);
    } else
      map.put(val, new Interval(val, val));
  }

  public List<Interval> getIntervals() {
    return new ArrayList<>(map.values());
  }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); List<Interval>
 * param_2 = obj.getIntervals();
 */
