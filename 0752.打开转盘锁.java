/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public int openLock(String[] deadends, String target) {
        int begin = 0, end = Integer.parseInt(target), result = 0;
        boolean[] visited = new boolean[10000];
        HashSet<Integer> dead = new HashSet<>();
        for (String deadend : deadends)
            dead.add(Integer.parseInt(deadend));
        if (dead.contains(0))
            return -1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(begin);
        visited[begin] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.pollLast();
                if (value == end)
                    return result;
                for (int j = 1; j <= 1000; j *= 10) {
                    int digit = (value % (j * 10)) / j, upper, lower;
                    if (digit == 9) {
                        upper = value - 9 * j;
                        lower = value - j;
                    } else if (digit == 0) {
                        upper = value + j;
                        lower = value + 9 * j;
                    } else {
                        upper = value + j;
                        lower = value - j;
                    }
                    if (!visited[upper] && !dead.contains(upper)) {
                        visited[upper] = true;
                        queue.addFirst(upper);
                    }
                    if (!visited[lower] && !dead.contains(lower)) {
                        visited[lower] = true;
                        queue.addFirst(lower);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
// @lc code=end
