import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
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
