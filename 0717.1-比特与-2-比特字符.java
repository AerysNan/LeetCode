/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0, n = bits.length;
        while (i < n) {
            if (bits[i] == 0) {
                if (i == n - 1)
                    return true;
                i++;
            } else {
                if (i == n - 2)
                    return false;
                i += 2;
            }
        }
        return true;
    }
}
// @lc code=end
