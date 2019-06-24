import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1054 lang=java
 *
 * [1054] 距离相等的条形码
 */
class Solution {
  class BarCode implements Comparable<BarCode> {
    int val;
    int cnt;

    BarCode(int val, int cnt) {
      this.val = val;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(BarCode b) {
      return b.cnt - this.cnt;
    }
  }

  public int[] rearrangeBarcodes(int[] barcodes) {
    PriorityQueue<BarCode> queue = new PriorityQueue<>();
    int[] counts = new int[10001];
    for (int b : barcodes)
      counts[b]++;
    for (int i = 0; i <= 10000; i++)
      if (counts[i] != 0)
        queue.add(new BarCode(i, counts[i]));
    int[] result = new int[barcodes.length];
    BarCode stash = null;
    for (int i = 0; i < barcodes.length; i++) {
      BarCode code = queue.poll();
      result[i] = code.val;
      if (stash != null)
        queue.add(stash);
      code.cnt--;
      stash = code;
    }
    return result;
  }
}
