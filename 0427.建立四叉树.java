/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start

// Definition for a QuadTree node.
/*
 * class Node { public boolean val; public boolean isLeaf; public Node topLeft; public Node
 * topRight; public Node bottomLeft; public Node bottomRight;
 * 
 * 
 * public Node() { this.val = false; this.isLeaf = false; this.topLeft = null; this.topRight = null;
 * this.bottomLeft = null; this.bottomRight = null; }
 * 
 * public Node(boolean val, boolean isLeaf) { this.val = val; this.isLeaf = isLeaf; this.topLeft =
 * null; this.topRight = null; this.bottomLeft = null; this.bottomRight = null; }
 * 
 * public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node
 * bottomRight) { this.val = val; this.isLeaf = isLeaf; this.topLeft = topLeft; this.topRight =
 * topRight; this.bottomLeft = bottomLeft; this.bottomRight = bottomRight; } };
 */

class Solution {
  public Node construct(int[][] grid) {
    return build(grid, 0, 0, grid.length, grid[0].length);
  }

  Node build(int[][] grid, int x1, int y1, int x2, int y2) {
    if (identical(grid, x1, y1, x2, y2))
      return new Node(grid[x1][y1] == 1, true);
    int xMid = (x1 + x2) / 2, yMid = (y1 + y2) / 2;
    Node topLeft = build(grid, x1, y1, xMid, yMid);
    Node bottomLeft = build(grid, xMid, y1, x2, yMid);
    Node topRight = build(grid, x1, yMid, xMid, y2);
    Node bottomRight = build(grid, xMid, yMid, x2, y2);
    return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
  }

  boolean identical(int[][] grid, int x1, int y1, int x2, int y2) {
    int value = grid[x1][y1];
    for (int x = x1; x < x2; x++)
      for (int y = y1; y < y2; y++)
        if (grid[x][y] != value)
          return false;
    return true;
  }
}
// @lc code=end

