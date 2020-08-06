/*
 * @lc app=leetcode.cn id=761 lang=java
 *
 * [761] 特殊的二进制序列
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    int[] map;

    public String makeLargestSpecial(String S) {
        int n = S.length();
        map = new int[n];
        char[] array = S.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (array[i] == '1')
                stack.push(i);
            else
                map[stack.pop()] = i;
        }
        solve(array, 0, n - 1);
        return new String(array);
    }

    void solve(char[] array, int l, int r) {
        if (l > r)
            return;
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = l; i <= r;) {
            solve(array, i + 1, map[i] - 1);
            queue.add(new String(array, i, map[i] - i + 1));
            i = map[i] + 1;
        }
        while (!queue.isEmpty())
            for (char c : queue.poll().toCharArray())
                array[l++] = c;
    }
}
// @lc code=end
