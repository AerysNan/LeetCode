import javax.print.attribute.standard.Media;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (33.24%)
 * Total Accepted:    1.3K
 * Total Submissions: 3.9K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 *
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 *
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 *
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
