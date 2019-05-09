import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */
class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) {
      result.add(newInterval);
      return result;
    }
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> valueList = new ArrayList<>();
    ArrayList<Boolean> actionList = new ArrayList<>();
    for (Interval interval : intervals) {
      valueList.add(interval.start);
      actionList.add(true);
      valueList.add(interval.end);
      actionList.add(false);
    }
    int pushIndex = 0;
    while (pushIndex < valueList.size() && newInterval.start > valueList.get(pushIndex))
      pushIndex++;
    valueList.add(pushIndex, newInterval.start);
    actionList.add(pushIndex, true);
    int popIndex = valueList.size() - 1;
    while (newInterval.end < valueList.get(popIndex))
      popIndex--;
    valueList.add(popIndex + 1, newInterval.end);
    actionList.add(popIndex + 1, false);
    int length = valueList.size();
    for (int i = 0; i < length; i++) {
      if (actionList.get(i))
        stack.add(valueList.get(i));
      else {
        int begin = stack.pop();
        if (stack.isEmpty())
          result.add(new Interval(begin, valueList.get(i)));
      }
    }
    return result;
  }
}
