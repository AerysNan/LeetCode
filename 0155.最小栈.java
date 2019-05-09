import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> helper;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<>();
    helper = new Stack<>();
    helper.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    stack.push(x);
    helper.push(Math.min(helper.peek(), x));
  }

  public void pop() {
    stack.pop();
    helper.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return helper.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
