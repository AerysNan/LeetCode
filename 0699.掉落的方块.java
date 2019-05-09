import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=699 lang=java
 *
 * [699] 掉落的方块
 */
class Solution {
  class SegmentTree {
    class SegmentTreeNode {
      SegmentTreeNode parent;
      SegmentTreeNode lChild, rChild;
      int lBound, rBound;
      int value;
      boolean lazy;

      SegmentTreeNode(int lBound, int rBound) {
        this.lBound = lBound;
        this.rBound = rBound;
        this.value = 0;
        this.lazy = false;
      }
    }

    SegmentTreeNode root;

    void build(SegmentTreeNode node) {
      if (node.lBound == node.rBound)
        return;
      int middle = (node.rBound - node.lBound) / 2 + node.lBound;
      SegmentTreeNode lNode = new SegmentTreeNode(node.lBound, middle);
      SegmentTreeNode rNode = new SegmentTreeNode(middle + 1, node.rBound);
      lNode.parent = node;
      rNode.parent = node;
      node.lChild = lNode;
      node.rChild = rNode;
      build(lNode);
      build(rNode);
    }

    SegmentTree(int size) {
      root = new SegmentTreeNode(0, size - 1);
      build(root);
    }

    int find(int l, int r) {
      return findValue(l, r, root);
    }

    int findValue(int l, int r, SegmentTreeNode node) {
      adjust(node);
      if (l <= node.lBound && r >= node.rBound)
        return node.value;
      int middle = (node.rBound - node.lBound) / 2 + node.lBound;
      if (middle < l)
        return findValue(l, r, node.rChild);
      if (middle >= r)
        return findValue(l, r, node.lChild);
      return Math.max(findValue(l, middle, node.lChild), findValue(middle + 1, r, node.rChild));
    }

    void update(int l, int r, int value) {
      updateValue(l, r, value, root);
    }

    void adjust(SegmentTreeNode node) {
      if (node.lazy) {
        if (node.lBound == node.rBound) {
          node.lazy = false;
          return;
        }
        node.lChild.value = Math.max(node.lChild.value, node.value);
        node.rChild.value = Math.max(node.rChild.value, node.value);
        node.lazy = false;
        node.lChild.lazy = true;
        node.rChild.lazy = true;
      }
    }

    void updateValue(int l, int r, int value, SegmentTreeNode node) {
      adjust(node);
      node.value = Math.max(node.value, value);
      if (node.lBound == node.rBound)
        return;
      if (node.lBound >= l && node.rBound <= r) {
        node.lazy = true;
        return;
      }
      int middle = (node.rBound - node.lBound) / 2 + node.lBound;
      if (middle >= r)
        updateValue(l, r, value, node.lChild);
      else if (middle < l)
        updateValue(l, r, value, node.rChild);
      else {
        updateValue(l, middle, value, node.lChild);
        updateValue(middle + 1, r, value, node.rChild);
      }
    }
  }

  private HashMap<Integer, Integer> compress(int[][] positions) {
    HashSet<Integer> set = new HashSet<>();
    for (int[] position : positions) {
      set.add(position[0]);
      set.add(position[0] + position[1] - 1);
    }
    ArrayList<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;
    for (int position : list)
      map.put(position, index++);
    return map;
  }

  public List<Integer> fallingSquares(int[][] positions) {
    ArrayList<Integer> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    HashMap<Integer, Integer> map = compress(positions);
    SegmentTree tree = new SegmentTree(map.size());
    for (int[] position : positions) {
      int l = map.get(position[0]);
      int r = map.get(position[0] + position[1] - 1);
      int value = tree.find(l, r);
      int height = value + position[1];
      tree.update(l, r, height);
      max = Math.max(max, height);
      result.add(max);
    }
    return result;
  }
}
