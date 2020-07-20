/*
 * @lc app=leetcode.cn id=715 lang=java
 *
 * [715] Range 模块
 */

// @lc code=start
import java.util.TreeMap;

class RangeModule {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addRange(int left, int right) {
        Integer start = map.floorKey(left), end = map.floorKey(right);
        if (start != null && map.get(start) >= left)
            left = start;
        if (end != null && map.get(end) > right)
            right = map.get(end);
        map.put(left, right);
        map.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left), end = map.floorKey(right);
        if (end != null && map.get(end) > right)
            map.put(right, map.get(end));
        if (start != null && map.get(start) > left)
            map.put(start, left);
        map.subMap(left, true, right, false).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such: RangeModule
 * obj = new RangeModule(); obj.addRange(left,right); boolean param_2 =
 * obj.queryRange(left,right); obj.removeRange(left,right);
 */
// @lc code=end
