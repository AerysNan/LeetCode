/*
 * @lc app=leetcode.cn id=1117 lang=java
 *
 * [1117] H2O 生成
 */

// @lc code=start
import java.util.concurrent.Semaphore;

class H2O {
  Semaphore h, o;

  public H2O() {
    h = new Semaphore(2);
    o = new Semaphore(0);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    h.acquire(1);
    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    releaseHydrogen.run();
    o.release(1);
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    o.acquire(2);
    // releaseOxygen.run() outputs "O". Do not change or remove this line.
    releaseOxygen.run();
    h.release(2);
  }
}
// @lc code=end
