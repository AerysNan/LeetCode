/*
 * @lc app=leetcode.cn id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        PriorityQueue<int[]> projects = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++)
            projects.add(new int[] { Profits[i], Capital[i] });
        while (k > 0) {
            while (!projects.isEmpty() && projects.peek()[1] <= W)
                available.add(projects.poll()[0]);
            if (available.isEmpty())
                break;
            W += available.poll();
            k--;
        }
        return W;
    }
}
// @lc code=end
