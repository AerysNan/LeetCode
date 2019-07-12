import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */
class Solution {
  public int videoStitching(int[][] clips, int T) {
    Arrays.sort(clips, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        int value = i1[0] - i2[0];
        return value != 0 ? value : (i1[1] - i2[1]);
      }
    });
    if (clips.length == 0 || clips[0][0] != 0)
      return -1;
    int result = 0, currentEnd = 0, index = 0;
    while (currentEnd < T && index < clips.length) {
      boolean found = false;
      int value = -1;
      while (index < clips.length) {
        if (clips[index][0] > currentEnd)
          break;
        found = true;
        value = Math.max(value, clips[index][1]);
        index++;
      }
      if (!found)
        return -1;
      currentEnd = value;
      result++;
    }
    if (currentEnd < T)
      return -1;
    return result;
  }
}
