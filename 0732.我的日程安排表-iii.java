/*
 * @lc app=leetcode.cn id=732 lang=java
 *
 * [732] 我的日程安排表 III
 */

// @lc code=start
import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap<>();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);
        int active = 0, result = 0;
        for (int d : delta.values()) {
            active += d;
            if (active > result)
                result = active;
        }
        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree(); int param_1 =
 * obj.book(start,end);
 */
// @lc code=end
