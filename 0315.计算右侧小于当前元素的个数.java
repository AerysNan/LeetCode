/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
  Node l, r;
  int value, count, dup;

  Node(int value, int count) {
    this.value = value;
    this.count = count;
    this.dup = 1;
  }
}


class Solution {
  public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
    if (n == 0)
      return result;
    Node root = new Node(nums[n - 1], 0);
    for (int i = n - 2; i >= 0; i--)
      result.set(i, insert(root, nums[i], 0));
    return result;
  }

  int insert(Node node, int num, int sum) {
    if (node.value == num) {
      node.dup++;
      return node.count + sum;
    }
    if (node.value > num) {
      node.count++;
      if (node.l == null) {
        node.l = new Node(num, 0);
        return sum;
      }
      return insert(node.l, num, sum);
    }
    if (node.r == null) {
      node.r = new Node(num, 0);
      return sum + node.dup + node.count;
    }
    return insert(node.r, num, sum + node.dup + node.count);
  }
}
// @lc code=end

