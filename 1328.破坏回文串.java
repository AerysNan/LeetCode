/*
 * @lc app=leetcode.cn id=1328 lang=java
 *
 * [1328] 破坏回文串
 */

// @lc code=start
class Solution {
  public String breakPalindrome(String palindrome) {
    if (palindrome.length() == 1)
      return "";
    char[] array = palindrome.toCharArray();
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] != 'a') {
        array[i] = 'a';
        return new String(array);
      }
    }
    array[n - 1] = 'b';
    return new String(array);
  }
}
// @lc code=end

