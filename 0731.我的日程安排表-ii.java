/*
 * @lc app=leetcode.cn id=731 lang=java
 *
 * [731] 我的日程安排表 II
 */

// @lc code=start
import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int d : map.values()) {
            active += d;
            if (active >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo(); boolean param_1 =
 * obj.book(start,end);
 */
// @lc code=end
