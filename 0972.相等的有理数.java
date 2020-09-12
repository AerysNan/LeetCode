/*
 * @lc app=leetcode.cn id=972 lang=java
 *
 * [972] 相等的有理数
 */

// @lc code=start
class Solution {
  public boolean isRationalEqual(String S, String T) {
    Fraction f1 = convert(S);
    Fraction f2 = convert(T);
    return f1.n == f2.n && f1.d == f2.d;
  }

  public Fraction convert(String S) {
    int state = 0, prev = 0;
    Fraction result = new Fraction(0, 1);
    for (String part : S.split("[.()]")) {
      state++;
      if (part.isEmpty())
        continue;
      long x = Long.valueOf(part);
      int n = part.length();
      if (state == 1)
        result.add(new Fraction(x, 1));
      else if (state == 2) {
        result.add(new Fraction(x, (long) Math.pow(10, n)));
        prev = n;
      } else {
        long denom = (long) Math.pow(10, prev);
        denom *= (long) (Math.pow(10, n) - 1);
        result.add(new Fraction(x, denom));
      }
    }
    return result;
  }
}

class Fraction {
  long n, d;

  Fraction(long n, long d) {
    long g = gcd(n, d);
    this.n = n / g;
    this.d = d / g;
  }

  public void add(Fraction other) {
    long numerator = this.n * other.d + this.d * other.n;
    long denominator = this.d * other.d;
    long g = Fraction.gcd(numerator, denominator);
    this.n = numerator / g;
    this.d = denominator / g;
  }

  static long gcd(long x, long y) {
    return x != 0 ? gcd(y % x, x) : y;
  }
}
// @lc code=end
