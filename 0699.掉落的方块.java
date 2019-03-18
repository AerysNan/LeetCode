import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=699 lang=java
 *
 * [699] 掉落的方块
 *
 * https://leetcode-cn.com/problems/falling-squares/description/
 *
 * algorithms
 * Hard (36.17%)
 * Total Accepted:    137
 * Total Submissions: 380
 * Testcase Example:  '[[1,2],[2,3],[6,1]]'
 *
 * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
 *
 * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left
 * 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
 *
 * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
 *
 *
 * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
 *
 *
 *
 * 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ...,
 * positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1, 2], [2, 3], [6, 1]]
 * 输出: [2, 5, 5]
 * 解释:
 *
 * 第一个方块 positions[0] = [1, 2] 掉落：
 * _aa
 * _aa
 * -------
 * 方块最大高度为 2 。
 *
 * 第二个方块 positions[1] = [2, 3] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa__
 * _aa__
 * --------------
 * 方块最大高度为5。
 * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
 *
 * 第三个方块 positions[1] = [6, 1] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa
 * _aa___a
 * --------------
 * 方块最大高度为5。
 *
 * 因此，我们返回结果[2, 5, 5]。
 *
 *
 *
 *
 * 示例 2:
 *
 * 输入: [[100, 100], [200, 100]]
 * 输出: [100, 100]
 * 解释: 相邻的方块不会过早地卡住，只有它们的底部边缘才能粘在表面上。
 *
 *
 *
 *
 * 注意:
 *
 *
 * 1 <= positions.length <= 1000.
 * 1 <= positions[i][0] <= 10^8.
 * 1 <= positions[i][1] <= 10^6.
 *
 *
 *
 *
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
