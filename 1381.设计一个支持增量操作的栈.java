/*
 * @lc app=leetcode.cn id=5357 lang=java
 *
 * [5357] 设计一个支持增量操作的栈
 */

// @lc code=start
import java.util.LinkedList;

class CustomStack {

  LinkedList<Integer> stack;
  int maxSize;

  public CustomStack(int maxSize) {
    this.maxSize = maxSize;
    this.stack = new LinkedList<>();
  }

  public void push(int x) {
    if (stack.size() == maxSize)
      return;
    stack.addLast(x);
  }

  public int pop() {
    if (stack.isEmpty())
      return -1;
    return stack.pollLast();
  }

  public void increment(int k, int val) {
    int n = Math.min(k, stack.size());
    for (int i = 0; i < n; i++)
      stack.set(i, stack.get(i) + val);
  }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack obj = new
 * CustomStack(maxSize); obj.push(x); int param_2 = obj.pop(); obj.increment(k,val);
 */
// @lc code=end

