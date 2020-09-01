/*
 * @lc app=leetcode.cn id=805 lang=java
 *
 * [805] 数组的均值分割
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.awt.Point;

class Solution {
  public boolean splitArraySameAverage(int[] A) {
    int n = A.length;
    if (n == 1)
      return false;
    int sum = Arrays.stream(A).sum();
    int g = gcd(sum, n);
    Point minusAverage = new Point(-(sum / g), n / g);
    ArrayList<Point> list = new ArrayList<>();
    for (int x : A)
      list.add(fracAdd(new Point(x, 1), minusAverage));
    HashSet<Point> left = new HashSet<>();
    left.add(list.get(0));
    for (int i = 1; i < n / 2; i++) {
      HashSet<Point> buffer = new HashSet<>();
      Point z = list.get(i);
      buffer.add(z);
      for (Point p : left) {
        buffer.add(p);
        buffer.add(fracAdd(p, z));
      }
      left = buffer;
    }
    if (left.contains(new Point(0, 1)))
      return true;
    HashSet<Point> right = new HashSet<>();
    right.add(list.get(n - 1));
    for (int i = n / 2; i < n - 1; ++i) {
      HashSet<Point> buffer = new HashSet<>();
      Point z = list.get(i);
      buffer.add(z);
      for (Point p : right) {
        buffer.add(p);
        buffer.add(fracAdd(p, z));
      }
      right = buffer;
    }

    if (right.contains(new Point(0, 1)))
      return true;
    Point sleft = new Point(0, 1);
    for (int i = 0; i < n / 2; ++i)
      sleft = fracAdd(sleft, list.get(i));
    Point sright = new Point(0, 1);
    for (int i = n / 2; i < n; ++i)
      sright = fracAdd(sright, list.get(i));
    for (Point ha : left) {
      Point minus = new Point(-ha.x, ha.y);
      if (right.contains(minus) && (!ha.equals(sleft) || !minus.equals(sright)))
        return true;
    }
    return false;
  }

  public Point fracAdd(Point A, Point B) {
    int numer = A.x * B.y + B.x * A.y;
    int denom = A.y * B.y;
    int g = gcd(numer, denom);
    numer /= g;
    denom /= g;
    if (denom < 0) {
      numer *= -1;
      denom *= -1;
    }
    return new Point(numer, denom);
  }

  public int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}

// @lc code=end
