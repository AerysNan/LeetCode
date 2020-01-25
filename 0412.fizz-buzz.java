/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<String> fizzBuzz(int n) {
    ArrayList<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0)
        result.add("FizzBuzz");
      else if (i % 3 == 0)
        result.add("Fizz");
      else if (i % 5 == 0)
        result.add("Buzz");
      else
        result.add(String.valueOf(i));
    }
    return result;
  }
}
// @lc code=end

