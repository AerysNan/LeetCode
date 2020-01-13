/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
import java.util.Random;

class Solution {
  int[] content;

  public Solution(int[] nums) {
    this.content = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return content;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] result = new int[content.length];
    Random random = new Random();
    System.arraycopy(content, 0, result, 0, content.length);
    for (int i = result.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      int tmp = result[index];
      result[index] = result[i];
      result[i] = tmp;
    }
    return result;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset(); int[] param_2 = obj.shuffle();
 */
// @lc code=end

