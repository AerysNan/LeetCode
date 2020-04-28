/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int n = S.length(), index = n - 1, count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index >= 0) {
            char c = S.charAt(index--);
            if (c == '-')
                continue;
            if (c >= 'a' && c <= 'z')
                c = Character.toUpperCase(c);
            stringBuilder.append(c);
            count++;
            if (count == K && index >= 0) {
                stringBuilder.append('-');
                count = 0;
            }
        }
        String result = stringBuilder.reverse().toString();
        return !result.isEmpty() && result.charAt(0) == '-' ? result.substring(1) : result;
    }
}
// @lc code=end
