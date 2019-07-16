/*
 * @lc app=leetcode.cn id=1041 lang=java
 *
 * [1041] 困于环中的机器人
 */
class Solution {
  int[][] move = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public boolean isRobotBounded(String instructions) {
    int X = 0, Y = 0, dir = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < instructions.length(); j++) {
        if (instructions.charAt(j) == 'G') {
          X += move[dir][0];
          Y += move[dir][1];
        } else if (instructions.charAt(j) == 'L')
          dir = (dir + 1) % 4;
        else
          dir = (dir + 3) % 4;
      }
    }
    return X == 0 && Y == 0 && dir == 0;
  }
}
