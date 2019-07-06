import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */
class Solution {
  public List<Boolean> prefixesDivBy5(int[] A) {
    ArrayList<Boolean> result = new ArrayList<>();
    int current = 0;
    for (int value : A) {
      current = (2 * current + value) % 10;
      if (current == 0 || current == 5)
        result.add(true);
      else
        result.add(false);
    }
    return result;
  }
}
