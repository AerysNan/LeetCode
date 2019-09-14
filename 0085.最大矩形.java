import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int m = matrix.length, n = matrix[0].length;
    int[][] count = new int[m][n];
    for (int i = 0; i < n; i++)
      count[0][i] = matrix[0][i] - '0';
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '0')
          count[i][j] = 0;
        else
          count[i][j] = count[i - 1][j] + 1;
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++)
      result = Math.max(result, compute(count[i]));
    return result;
  }

  int compute(int[] nums) {
    int result = Integer.MIN_VALUE;
    LinkedList<Integer> mono = new LinkedList<>();
    int index = 0, n = nums.length;
    while (index < n) {
      int value = nums[index];
      if (mono.isEmpty() || value >= nums[mono.peekLast()])
        mono.addLast(index++);
      else {
        int height = nums[mono.pollLast()];
        result = Math.max(result, height * (mono.isEmpty() ? index : index - 1 - mono.peekLast()));
      }
    }
    while (!mono.isEmpty()) {
      int height = nums[mono.pollLast()];
      result = Math.max(result, height * (mono.isEmpty() ? n : n - 1 - mono.peekLast()));
    }
    return result;
  }
}
// @lc code=end

