/*
 * @lc app=leetcode.cn id=480 lang=java
 *
 * [480] 滑动窗口中位数
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Double> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> r = new PriorityQueue<>(), l = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        while (index < k)
            l.add(nums[index++]);
        for (int i = 0; i < k / 2; i++)
            r.add(l.poll());
        while (true) {
            result.add(k % 2 == 0 ? l.peek() * 0.5 + r.peek() * 0.5 : l.peek());
            if (index >= nums.length)
                break;
            int out = nums[index - k], in = nums[index++], balance = 0;
            balance += out <= l.peek() ? -1 : 1;
            map.put(out, map.getOrDefault(out, 0) + 1);
            if (!l.isEmpty() && in <= l.peek()) {
                balance++;
                l.add(in);
            } else {
                balance--;
                r.add(in);
            }
            if (balance < 0)
                l.add(r.poll());
            if (balance > 0)
                r.add(l.poll());
            while (map.getOrDefault(l.peek(), 0) > 0) {
                map.put(l.peek(), map.get(l.peek()) - 1);
                l.poll();
            }
            while (!r.isEmpty() && map.getOrDefault(r.peek(), 0) > 0) {
                map.put(r.peek(), map.get(r.peek()) - 1);
                r.poll();
            }
        }
        return result.stream().mapToDouble(i -> i).toArray();
    }
}
// @lc code=end
