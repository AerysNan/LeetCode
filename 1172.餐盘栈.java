import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1172 lang=java
 *
 * [1172] 餐盘栈
 */

// @lc code=start
class DinnerPlates {
  ArrayList<Stack<Integer>> stacks;
  int capacity;
  int l, r;

  public DinnerPlates(int capacity) {
    this.capacity = capacity;
    stacks = new ArrayList<>();
    stacks.add(new Stack<>());
    l = 0;
    r = -1;
  }

  public void push(int val) {
    stacks.get(l).push(val);
    r = Math.max(l, r);
    while (l < stacks.size() && stacks.get(l).size() == capacity)
      l++;
    if (l == stacks.size())
      stacks.add(new Stack<>());
  }

  public int pop() {
    if (r == -1)
      return -1;
    int value = stacks.get(r).pop();
    l = Math.min(l, r);
    while (r >= 0 && stacks.get(r).isEmpty())
      r--;
    return value;
  }

  public int popAtStack(int index) {
    if (index >= stacks.size() || stacks.get(index).isEmpty())
      return -1;
    int value = stacks.get(index).pop();
    if (index < l)
      l = index;
    while (r >= 0 && stacks.get(r).isEmpty())
      r--;
    return value;
  }
}
// @lc code=end
