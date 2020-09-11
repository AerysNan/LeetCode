import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=835 lang=java
 *
 * [835] 图像重叠
 */

// @lc code=start
class Solution {
  public int largestOverlap(int[][] img1, int[][] img2) {
    int n = img1.length;
    int[][] count = new int[2 * n - 1][2 * n - 1];
    for (int i1 = 0; i1 < n; i1++)
      for (int j1 = 0; j1 < n; j1++)
        if (img1[i1][j1] == 1)
          for (int i2 = 0; i2 < n; ++i2)
            for (int j2 = 0; j2 < n; ++j2)
              if (img2[i2][j2] == 1)
                count[i1 - i2 + n - 1][j1 - j2 + n - 1] += 1;
    return Arrays.stream(count).flatMap(x -> Arrays.stream(x).boxed()).mapToInt(x -> x).max().getAsInt();
  }
}
// @lc code=end
