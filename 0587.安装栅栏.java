import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=587 lang=java
 *
 * [587] 安装栅栏
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
