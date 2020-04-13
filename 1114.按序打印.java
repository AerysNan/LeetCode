/*
 * @lc app=leetcode.cn id=1114 lang=java
 *
 * [1114] 按序打印
 */

// @lc code=start
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
  ReentrantLock lock;
  Condition condition_1, condition_2;
  AtomicInteger value;

  public Foo() {
    lock = new ReentrantLock();
    condition_1 = lock.newCondition();
    condition_2 = lock.newCondition();
    value = new AtomicInteger();
  }

  public void first(Runnable printFirst) throws InterruptedException {
    lock.lock();
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    value.incrementAndGet();
    condition_1.signal();
    lock.unlock();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    lock.lock();
    if (value.intValue() < 1)
      condition_1.await();
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    value.incrementAndGet();
    condition_2.signal();
    lock.unlock();
  }

  public void third(Runnable printThird) throws InterruptedException {
    lock.lock();
    if (value.intValue() < 2)
      condition_2.await();
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
    lock.unlock();
  }
}
// @lc code=end

