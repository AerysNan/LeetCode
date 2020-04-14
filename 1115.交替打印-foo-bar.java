/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印FooBar
 */

// @lc code=start
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
  private int n;
  AtomicBoolean value;
  ReentrantLock lock;
  Condition condition;

  public FooBar(int n) {
    this.n = n;
    value = new AtomicBoolean();
    lock = new ReentrantLock();
    condition = lock.newCondition();
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      lock.lock();
      if (value.get())
        condition.await();
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      value.getAndSet(true);
      condition.signal();
      lock.unlock();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      lock.lock();
      if (!value.get())
        condition.await();
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      value.getAndSet(false);
      condition.signal();
      lock.unlock();
    }
  }
}
// @lc code=end

