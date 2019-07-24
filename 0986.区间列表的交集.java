import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */
class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    ArrayList<int[]> result = new ArrayList<>();
    int m = A.length, n = B.length, i = 0, j = 0;
    while (i < m && j < n) {
      int[] intersection = getIntersection(A[i], B[j]);
      if (intersection != null)
        result.add(intersection);
      if (A[i][1] < B[j][1])
        i++;
      else if (A[i][1] > B[j][1])
        j++;
      else {
        i++;
        j++;
      }

    }
    int[][] intersections = new int[result.size()][2];
    for (int k = 0; k < result.size(); k++) {
      intersections[k][0] = result.get(k)[0];
      intersections[k][1] = result.get(k)[1];
    }
    return intersections;
  }

  int[] getIntersection(int[] A, int[] B) {
    if (A[1] < B[0] || B[1] < A[0])
      return null;
    return new int[] { Math.max(A[0], B[0]), Math.min(A[1], B[1]) };
  }
}
