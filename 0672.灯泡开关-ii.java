/*
 * @lc app=leetcode.cn id=672 lang=java
 *
 * [672] 灯泡开关 Ⅱ
 */

// @lc code=start
import java.util.HashSet;

class Solution {
    public int flipLights(int n, int m) {
        HashSet<Integer> result = new HashSet<>();
        n = Math.min(n, 6);
        int shift = Math.max(0, 6 - n);
        for (int action = 0; action < 16; ++action) {
            int count = Integer.bitCount(action);
            if (count % 2 == m % 2 && count <= m) {
                int status = 0;
                if (((action >> 0) & 1) > 0)
                    status ^= 0b111111 >> shift;
                if (((action >> 1) & 1) > 0)
                    status ^= 0b010101 >> shift;
                if (((action >> 2) & 1) > 0)
                    status ^= 0b101010 >> shift;
                if (((action >> 3) & 1) > 0)
                    status ^= 0b100100 >> shift;
                result.add(status);
            }
        }
        return result.size();
    }
}
// @lc code=end
