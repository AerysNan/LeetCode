/*
 * @lc app=leetcode.cn id=1116 lang=java
 *
 * [1116] 打印零与奇偶数
 */

// @lc code=start
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
  private int n;
  Semaphore zero, odd, even;

  public ZeroEvenOdd(int n) {
    this.n = n;
    zero = new Semaphore(1);
    odd = new Semaphore(0);
    even = new Semaphore(0);
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      zero.acquire(1);
      printNumber.accept(0);
      if (i % 2 == 0)
        odd.release(1);
      else
        even.release(1);
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      even.acquire(1);
      printNumber.accept(i);
      zero.release(1);
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      odd.acquire(1);
      printNumber.accept(i);
      zero.release(1);
    }
  }
}
// @lc code=end
