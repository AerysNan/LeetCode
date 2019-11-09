import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
  public int maximumGap(int[] nums) {
    int n = nums.length;
    if (n <= 1)
      return 0;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if (max == min)
      return 0;
    int[] mins = new int[n + 1], maxs = new int[n + 1];
    boolean[] valid = new boolean[n + 1];
    Arrays.fill(mins, Integer.MAX_VALUE);
    Arrays.fill(maxs, Integer.MIN_VALUE);
    for (int num : nums) {
      long value = ((long) (num - min)) * n;
      int bucket = (int) (value / (max - min));
      if (bucket < 0)
        System.out.println("min: " + min + " max: " + max + " num: " + num);
      mins[bucket] = Math.min(mins[bucket], num);
      maxs[bucket] = Math.max(maxs[bucket], num);
      valid[bucket] = true;
    }
    int result = Integer.MIN_VALUE, i = 0;
    while (!valid[i])
      i++;
    int prev = maxs[i];
    for (int j = i + 1; j <= n; j++) {
      if (!valid[j])
        continue;
      result = Math.max(result, mins[j] - prev);
      prev = maxs[j];
    }
    return result;
  }
}
// @lc code=end

