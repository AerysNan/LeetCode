/*
 * @lc app=leetcode.cn id=481 lang=java
 *
 * [481] 神奇字符串
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
    public int magicalString(int n) {
        if (n == 0)
            return 0;
        if (n <= 3)
            return 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        int index = 2, value = 1;
        while (list.size() < n) {
            int count = list.get(index++);
            for (int i = 0; i < count; i++)
                list.add(value);
            value = 3 - value;
        }
        int result = 0;
        for (int i = 0; i < n; i++)
            if (list.get(i) == 1)
                result++;
        return result;

    }
}
// @lc code=end
