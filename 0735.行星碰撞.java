import java.util.Stack;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;
        outer: for (int i = 0; i < n; i++) {
            if (s.isEmpty() || !(s.peek() > 0 && asteroids[i] < 0)) {
                s.push(asteroids[i]);
                continue;
            }
            while (!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0) {
                int l = Math.abs(s.peek()), r = Math.abs(asteroids[i]);
                if (l <= r)
                    s.pop();
                if (l >= r)
                    continue outer;
            }
            s.push(asteroids[i]);
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end
