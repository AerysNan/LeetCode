import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */
class Solution {
  public void duplicateZeros(int[] arr) {
    ArrayList<Integer> tmp = new ArrayList<>();
    for (int a : arr) {
      if (a != 0)
        tmp.add(a);
      else {
        tmp.add(0);
        tmp.add(0);
      }
      if (tmp.size() > arr.length)
        break;
    }
    for (int i = 0; i < arr.length; i++)
      arr[i] = tmp.get(i);
  }
}
