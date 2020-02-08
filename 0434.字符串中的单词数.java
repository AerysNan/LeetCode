/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int countSegments(String s) {
    return (int) Arrays.stream(s.split(" ")).filter(x -> x.length() > 0).count();
  }
}
// @lc code=end

