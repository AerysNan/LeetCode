/*
* @lc app=leetcode.cn id=853 lang=java
*
* [853] 车队
*/

// @lc code=start
import java.util.Arrays;

class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length, result = 0;
    if (n == 0)
      return 0;
    double[][] cars = new double[n][2];
    for (int i = 0; i < n; i++) {
      cars[i][0] = position[i];
      cars[i][1] = (double) (target - position[i]) / speed[i];
    }
    Arrays.sort(cars, (x, y) -> Double.compare(x[0], y[0]));
    for (int i = 0; i < n; i++)
      System.out.println(Arrays.toString(cars[i]));
    for (int i = n - 1; i > 0; i--) {
      if (cars[i][1] < cars[i - 1][1])
        result++;
      else
        cars[i - 1][1] = cars[i][1];
    }
    return result + 1;
  }
}
// @lc code=end
