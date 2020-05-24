/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int accA = 0, accL = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                accL++;
                if (accL > 2)
                    return false;
            } else {
                accL = 0;
                if (c == 'A') {
                    accA++;
                    if (accA > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
