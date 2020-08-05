/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短完整词
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                map[c - 'A']++;
            else if (c >= 'a' && c <= 'z')
                map[c - 'a']++;
        }

        String result = "";
        outer: for (String word : words) {
            int[] buffer = new int[26];
            for (char c : word.toCharArray())
                buffer[c - 'a']++;
            for (int i = 0; i < 26; i++)
                if (buffer[i] < map[i])
                    continue outer;
            if (result.isEmpty() || result.length() > word.length())
                result = word;
        }
        return result;
    }

}
// @lc code=end
