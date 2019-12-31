/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class SegmentNode {
  int l, r, value;
  SegmentNode left, right;

  SegmentNode(int l, int r, int value) {
    this.l = l;
    this.r = r;
    this.value = value;
  }
}


class SegmentTree {
  SegmentNode root;

  SegmentTree(int[] values) {
    root = build(values, 0, values.length - 1);
  }

  SegmentNode build(int[] values, int l, int r) {
    if (l == r)
      return new SegmentNode(l, r, values[l]);
    int mid = (l + r) / 2;
    SegmentNode node = new SegmentNode(l, r, 0);
    node.left = build(values, l, mid);
    node.right = build(values, mid + 1, r);
    node.value = node.left.value + node.right.value;
    return node;
  }

  int search(int l, int r) {
    return find(root, l, r);
  }

  int find(SegmentNode node, int l, int r) {
    if (node.l == l && node.r == r)
      return node.value;
    int mid = (node.l + node.r) / 2;
    if (r <= mid)
      return find(node.left, l, r);
    if (l > mid)
      return find(node.right, l, r);
    return find(node.left, l, mid) + find(node.right, mid + 1, r);
  }

  void update(int index, int value) {
    set(root, index, value);
  }

  void set(SegmentNode node, int index, int value) {
    if (node.l == node.r && node.l == index) {
      node.value = value;
      return;
    }
    int mid = (node.l + node.r) / 2;
    if (index <= mid)
      set(node.left, index, value);
    else
      set(node.right, index, value);
    node.value = node.left.value + node.right.value;
  }
}


class NumArray {
  SegmentTree tree;

  public NumArray(int[] nums) {
    if (nums == null || nums.length == 0)
      return;
    tree = new SegmentTree(nums);
  }

  public void update(int i, int val) {
    tree.update(i, val);
  }

  public int sumRange(int i, int j) {
    return tree.search(i, j);
  }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

