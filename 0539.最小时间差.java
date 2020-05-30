/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
import java.util.List;
import java.util.stream.Collectors;

class Time {
    int h, m;

    public Time(int h, int m) {
        this.h = h;
        this.m = m;
    }

    public int sub(Time t) {
        return h * 60 + m - t.h * 60 - t.m;
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Time> list = timePoints.stream().map(timePoint -> {
            String[] segments = timePoint.split(":");
            return new Time(Integer.valueOf(segments[0]), Integer.valueOf(segments[1]));
        }).collect(Collectors.toList());
        list.sort((t1, t2) -> t1.h == t2.h ? t1.m - t2.m : t1.h - t2.h);
        int n = list.size(), result = list.get(0).sub(list.get(n - 1)) + 60 * 24;
        for (int i = 0; i < n - 1; i++)
            result = Math.min(result, list.get(i + 1).sub(list.get(i)));
        return result;
    }
}
// @lc code=end
