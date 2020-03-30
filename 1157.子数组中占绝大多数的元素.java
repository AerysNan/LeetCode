/*
 * @lc app=leetcode.cn id=1157 lang=java
 *
 * [1157] 子数组中占绝大多数的元素
 */

// @lc code=start
import java.util.HashMap;
import java.util.TreeSet;

class Node {
  int value, count;
  int l, r;

  Node lChild, rChild;

  public Node(int value, int count, int l, int r) {
    this.value = value;
    this.count = count;
    this.l = l;
    this.r = r;
  }

  public Node(int l, int r) {
    this.l = l;
    this.r = r;
  }
}


class SegmentTree {
  Node root;

  public SegmentTree(int[] array) {
    this.root = build(array, 0, array.length - 1);
  }

  Node build(int[] array, int l, int r) {
    if (l == r)
      return new Node(array[l], 1, l, r);
    int mid = (r - l) / 2 + l;
    Node node = new Node(l, r);
    node.lChild = build(array, l, mid);
    node.rChild = build(array, mid + 1, r);
    if (node.lChild.value == node.rChild.value) {
      node.value = node.lChild.value;
      node.count = node.lChild.count + node.rChild.count;
    } else {
      node.value = node.lChild.count >= node.rChild.count ? node.lChild.value : node.rChild.value;
      node.count = Math.abs(node.lChild.count - node.rChild.count);
    }
    return node;
  }

  int search(int l, int r) {
    return query(root, l, r).getKey();
  }

  Pair<Integer, Integer> query(Node node, int l, int r) {
    if (node.l == node.r)
      return new Pair<>(node.value, node.count);
    int mid = (node.r - node.l) / 2 + node.l;
    if (r <= mid)
      return query(node.lChild, l, r);
    if (l >= mid + 1)
      return query(node.rChild, l, r);
    Pair<Integer, Integer> pl = query(node.lChild, l, mid);
    Pair<Integer, Integer> pr = query(node.rChild, mid + 1, r);
    if (pl.getKey() == pr.getKey())
      return new Pair<>(pl.getKey(), pl.getValue() + pr.getValue());
    int value = pl.getValue() >= pr.getValue() ? pl.getKey() : pr.getKey();
    int count = Math.abs(pl.getValue() - pr.getValue());
    return new Pair<>(value, count);
  }
}


class MajorityChecker {
  SegmentTree tree;
  HashMap<Integer, TreeSet<Integer>> indices;
  HashMap<Integer, HashMap<Integer, Pair<Integer, Integer>>> cache;

  public MajorityChecker(int[] arr) {
    this.cache = new HashMap<>();
    this.tree = new SegmentTree(arr);
    this.indices = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!indices.containsKey(arr[i]))
        indices.put(arr[i], new TreeSet<>());
      indices.get(arr[i]).add(i);
    }
  }

  public int query(int left, int right, int threshold) {
    if (cache.containsKey(left) && cache.get(left).containsKey(right)) {
      Pair<Integer, Integer> p = cache.get(left).get(right);
      return p.getValue() < threshold ? -1 : p.getKey();
    }
    int value = tree.search(left, right);
    if (indices.get(value).size() < threshold)
      return -1;
    int count = indices.get(value).subSet(left, true, right, true).size();
    if (!cache.containsKey(left))
      cache.put(left, new HashMap<>());
    cache.get(left).put(right, new Pair<>(value, count));
    return count < threshold ? -1 : value;
  }
}

/**
 * Your MajorityChecker object will be instantiated and called as such: MajorityChecker obj = new
 * MajorityChecker(arr); int param_1 = obj.query(left,right,threshold);
 */
// @lc code=end

