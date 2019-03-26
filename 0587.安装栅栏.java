import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=587 lang=java
 *
 * [587] 安装栅栏
 *
 * https://leetcode-cn.com/problems/erect-the-fence/description/
 *
 * algorithms
 * Hard (28.60%)
 * Total Accepted:    137
 * Total Submissions: 478
 * Testcase Example:  '[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]'
 *
 * 在一个二维的花园中，有一些用 (x, y)
 * 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 *
 *
 *
 * 示例 2:
 *
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 *
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 *
 *
 *
 *
 * 注意:
 *
 *
 * 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
 * 输入的整数在 0 到 100 之间。
 * 花园至少有一棵树。
 * 所有树的坐标都是不同的。
 * 输入的点没有顺序。输出顺序也没有要求。
 *
 */
/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */
public class Solution {

  private class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
      if (p1.x > p2.x)
        return 1;
      if (p1.x == p2.x && p1.y > p2.y)
        return 1;
      return -1;
    }
  }

  private static boolean isCounterClockwise(Point p1, Point p2, Point p3) {
    int dx1 = p2.x - p1.x;
    int dy1 = p2.y - p1.y;
    int dx2 = p3.x - p1.x;
    int dy2 = p3.y - p1.y;
    return (dx1 * dy2 - dx2 * dy1) <= 0;
  }

  public List<Point> outerTrees(Point[] points) {
    int n = points.length;
    HashSet<Point> result = new HashSet<>();
    Arrays.sort(points, new PointComparator());
    ArrayList<Point> upper = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      while (upper.size() >= 2
          && !isCounterClockwise(upper.get(upper.size() - 2), upper.get(upper.size() - 1), points[i]))
        upper.remove(upper.size() - 1);
      upper.add(points[i]);
    }

    ArrayList<Point> lower = new ArrayList<>();
    for (int i = n - 1; i >= 0; i--) {
      while (lower.size() >= 2
          && !isCounterClockwise(lower.get(lower.size() - 2), lower.get(lower.size() - 1), points[i]))
        lower.remove(lower.size() - 1);
      lower.add(points[i]);
    }
    for (int i = 0; i < upper.size(); i++)
      result.add(upper.get(i));
    for (int i = 0; i < lower.size(); i++)
      result.add(lower.get(i));
    return new ArrayList<Point>(result);
  }
}
