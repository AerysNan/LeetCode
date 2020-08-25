import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=789 lang=java
 *
 * [789] 逃脱阻碍者
 */

// @lc code=start
class Solution {
  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    int[] source = new int[] { 0, 0 };
    int d = distance(source, target);
    return !Arrays.stream(ghosts).anyMatch(x -> distance(x, target) <= d);
  }

  public int distance(int[] x, int[] y) {
    return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
  }
}
// @lc code=end
