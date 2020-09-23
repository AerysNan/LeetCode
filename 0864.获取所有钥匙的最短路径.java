/*
 * @lc app=leetcode.cn id=864 lang=java
 *
 * [864] 获取所有钥匙的最短路径
 */

// @lc code=start
import java.awt.Point;

class Solution {
  int INF = Integer.MAX_VALUE;
  String[] grid;
  int R, C;
  Map<Character, Point> location;
  int[] dr = new int[] { -1, 0, 1, 0 };
  int[] dc = new int[] { 0, -1, 0, 1 };

  public int shortestPathAllKeys(String[] grid) {
    this.grid = grid;
    R = grid.length;
    C = grid[0].length();

    // location : the points of interest
    location = new HashMap();
    for (int r = 0; r < R; ++r)
      for (int c = 0; c < C; ++c) {
        char v = grid[r].charAt(c);
        if (v != '.' && v != '#')
          location.put(v, new Point(r, c));
      }

    int targetState = (1 << (location.size() / 2)) - 1;
    Map<Character, Map<Character, Integer>> dists = new HashMap();
    for (char place : location.keySet())
      dists.put(place, bfsFrom(place));

    // Dijkstra
    PriorityQueue<ANode> pq = new PriorityQueue<ANode>((a, b) -> Integer.compare(a.dist, b.dist));
    pq.offer(new ANode(new Node('@', 0), 0));
    Map<Node, Integer> finalDist = new HashMap();
    finalDist.put(new Node('@', 0), 0);

    while (!pq.isEmpty()) {
      ANode anode = pq.poll();
      Node node = anode.node;
      int d = anode.dist;
      if (finalDist.getOrDefault(node, INF) < d)
        continue;
      if (node.state == targetState)
        return d;

      for (char destination : dists.get(node.place).keySet()) {
        int d2 = dists.get(node.place).get(destination);
        int state2 = node.state;
        if (Character.isLowerCase(destination)) // key
          state2 |= (1 << (destination - 'a'));
        if (Character.isUpperCase(destination)) // lock
          if ((node.state & (1 << (destination - 'A'))) == 0) // no key
            continue;

        if (d + d2 < finalDist.getOrDefault(new Node(destination, state2), INF)) {
          finalDist.put(new Node(destination, state2), d + d2);
          pq.offer(new ANode(new Node(destination, state2), d + d2));
        }
      }
    }

    return -1;
  }

  public Map<Character, Integer> bfsFrom(char source) {
    int sr = location.get(source).x;
    int sc = location.get(source).y;
    boolean[][] seen = new boolean[R][C];
    seen[sr][sc] = true;
    int curDepth = 0;
    Queue<Point> queue = new LinkedList();
    queue.offer(new Point(sr, sc));
    queue.offer(null);
    Map<Character, Integer> dist = new HashMap();

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      if (p == null) {
        curDepth++;
        if (!queue.isEmpty())
          queue.offer(null);
        continue;
      }

      int r = p.x, c = p.y;
      if (grid[r].charAt(c) != source && grid[r].charAt(c) != '.') {
        dist.put(grid[r].charAt(c), curDepth);
        continue; // Stop walking from here if we reach a point of interest
      }

      for (int i = 0; i < 4; ++i) {
        int cr = r + dr[i];
        int cc = c + dc[i];
        if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
          if (grid[cr].charAt(cc) != '#') {
            queue.offer(new Point(cr, cc));
            seen[cr][cc] = true;
          }
        }
      }
    }

    return dist;
  }
}

class ANode {
  Node node;
  int dist;

  ANode(Node n, int d) {
    node = n;
    dist = d;
  }
}

class Node {
  char place;
  int state;

  Node(char p, int s) {
    place = p;
    state = s;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Node))
      return false;
    Node other = (Node) o;
    return (place == other.place && state == other.state);
  }

  @Override
  public int hashCode() {
    return 256 * state + place;
  }
}
// @lc code=end
