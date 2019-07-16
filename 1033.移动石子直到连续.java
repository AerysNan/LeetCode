import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] 移动石子直到连续
 */
class Solution {
  public int[] numMovesStones(int a, int b, int c) {
    int[] pos = new int[] { a, b, c };
    Arrays.sort(pos);
    int min = pos[0] + 1 == pos[1] && pos[2] - 1 == pos[1] ? 0
        : (pos[0] + 1 == pos[1] || pos[0] + 2 == pos[1] || pos[2] - 1 == pos[1] || pos[2] - 2 == pos[1] ? 1 : 2);
    int max = pos[2] - pos[0] - 2;
    return new int[] { min, max };
  }
}
