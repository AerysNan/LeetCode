/*
 * @lc app=leetcode.cn id=1309 lang=java
 *
 * [1309] 解码字母到整数映射
 */

// @lc code=start
class Solution {
  public String freqAlphabets(String s) {
    StringBuilder result = new StringBuilder();
    char[] array = s.toCharArray();
    int n = array.length, i = n - 1;
    while (i >= 0) {
      if (array[i] == '#') {
        int value = (array[i - 1] - '0') + (array[i - 2] - '0') * 10;
        result.append((char) (value - 1 + 'a'));
        i -= 3;
      } else
        result.append((char) (array[i--] - '0' - 1 + 'a'));
    }
    return result.reverse().toString();
  }
}
// @lc code=end

