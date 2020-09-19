/*
 * @lc app=leetcode.cn id=855 lang=java
 *
 * [855] 考场就座
 */

// @lc code=start
import java.util.ArrayList;

class ExamRoom {
  int n;
  ArrayList<Integer> list;

  public ExamRoom(int n) {
    this.n = n;
    this.list = new ArrayList<>();
  }

  public int seat() {
    if (list.size() == 0) {
      list.add(0);
      return 0;
    }
    int d = Math.max(list.get(0), n - 1 - list.get(list.size() - 1));
    for (int i = 0; i < list.size() - 1; ++i)
      d = Math.max(d, (list.get(i + 1) - list.get(i)) / 2);
    if (list.get(0) == d) {
      list.add(0, 0);
      return 0;
    }
    for (int i = 0; i < list.size() - 1; ++i) {
      if ((list.get(i + 1) - list.get(i)) / 2 == d) {
        list.add(i + 1, (list.get(i + 1) + list.get(i)) / 2);
        return list.get(i + 1);
      }
    }
    list.add(n - 1);
    return n - 1;
  }

  public void leave(int p) {
    for (int i = 0; i < list.size(); ++i)
      if (list.get(i) == p)
        list.remove(i);
  }
}

/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(n); int param_1 = obj.seat(); obj.leave(p);
 */
// @lc code=end
