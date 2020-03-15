/*
 * @lc app=leetcode.cn id=1352 lang=java
 *
 * [1352] 最后 K 个数的乘积
 */

// @lc code=start
import java.util.LinkedList;

class ProductOfNumbers {
  LinkedList<Integer> value;

  public ProductOfNumbers() {
    value = new LinkedList<>();
    value.add(1);
  }

  public void add(int num) {
    if (num == 0) {
      value.clear();
      value.add(1);
      return;
    }
    int last = value.isEmpty() ? 1 : value.peekLast();
    value.add(last * num);
  }

  public int getProduct(int k) {
    if (k > value.size() - 1)
      return 0;
    return value.peekLast() / value.get(value.size() - 1 - k);
  }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such: ProductOfNumbers obj = new
 * ProductOfNumbers(); obj.add(num); int param_2 = obj.getProduct(k);
 */
// @lc code=end

