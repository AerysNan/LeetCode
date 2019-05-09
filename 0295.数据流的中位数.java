import javax.print.attribute.standard.Media;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */
public class MedianFinder {
  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(1, (x, y) -> {
      long result = (long) y - (long) x;
      if (result > 0)
        return 1;
      if (result < 0)
        return -1;
      return 0;
    });
    minHeap.add(Integer.MAX_VALUE);
    maxHeap.add(Integer.MIN_VALUE);
  }

  private void adjust() {
    int maxSize = maxHeap.size();
    int minSize = minHeap.size();
    if (maxSize - minSize >= 2)
      minHeap.add(maxHeap.poll());
    else if (minSize - maxSize >= 2)
      maxHeap.add(minHeap.poll());
  }

  public void addNum(int num) {
    int lowerMax = maxHeap.peek();
    if (num <= lowerMax)
      maxHeap.add(num);
    else
      minHeap.add(num);
    adjust();
  }

  public double findMedian() {
    if (maxHeap.size() > minHeap.size())
      return (double) maxHeap.peek();
    else if (maxHeap.size() < minHeap.size())
      return (double) minHeap.peek();
    return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
