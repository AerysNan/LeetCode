/*
 * @lc app=leetcode.cn id=630 lang=java
 *
 * [630] 课程表 III
 */

// @lc code=start
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
// @lc code=end
