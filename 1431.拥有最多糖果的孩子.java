/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = Arrays.stream(candies).max().getAsInt();
    return Arrays.stream(candies).boxed().map(x -> (max - x <= extraCandies))
        .collect(Collectors.toList());

  }
}
// @lc code=end

