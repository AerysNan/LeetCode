import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (33.25%)
 * Total Accepted:    3.4K
 * Total Submissions: 10.1K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 *
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
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
