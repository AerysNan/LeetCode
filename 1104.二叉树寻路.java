import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */
class Solution {
  public List<Integer> pathInZigZagTree(int label) {
    int level = 0;
    ArrayList<Integer> pow = new ArrayList<>();
    pow.add(1);
    while (true) {
      int acc = pow.get(pow.size() - 1) * 2;
      pow.add(acc);
      level += 1;
      if (acc > label)
        break;
    }
    level--;
    LinkedList<Integer> path = new LinkedList<>();
    path.add(label);
    while (level > 0) {
      int next = path.getFirst() / 2;
      next = pow.get(level) + pow.get(level - 1) - 1 - next;
      path.addFirst(next);
      level--;
    }
    return path;
  }
}
