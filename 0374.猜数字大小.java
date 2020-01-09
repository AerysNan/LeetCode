/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/*
 * The guess API is defined in the parent class GuessGame.
 *
 * @param num, your guess
 *
 * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0 int guess(int
 * num);
 */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int l = 1, r = n;
    while (true) {
      int m = (r - l) / 2 + l;
      int result = guess(m);
      switch (result) {
        case -1:
          r = m - 1;
          break;
        case 1:
          l = m + 1;
          break;
        default:
          return m;
      }
    }
  }
}
// @lc code=end

