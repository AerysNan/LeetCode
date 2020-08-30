import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1226 lang=java
 *
 * [1226] 哲学家进餐
 */

// @lc code=start
class DiningPhilosophers {
  Semaphore[] forks;
  Semaphore count;

  public DiningPhilosophers() {
    forks = new Semaphore[5];
    for (int i = 0; i < 5; i++)
      forks[i] = new Semaphore(1);
    count = new Semaphore(4);
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
      Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
    count.acquire();
    forks[philosopher].acquire();
    pickRightFork.run();
    forks[(philosopher + 1) % 5].acquire();
    pickLeftFork.run();
    eat.run();
    putLeftFork.run();
    forks[(philosopher + 1) % 5].release();
    putRightFork.run();
    forks[philosopher].release();
    count.release();
  }
}
// @lc code=end
