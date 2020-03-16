/*
 * @lc app=leetcode.cn id=1357 lang=java
 *
 * [1357] 每隔 n 个顾客打折
 */

// @lc code=start
import java.util.HashMap;

class Cashier {
  int n, discount, current;
  HashMap<Integer, Integer> map;

  public Cashier(int n, int discount, int[] products, int[] prices) {
    this.n = n;
    this.discount = discount;
    this.current = 1;
    this.map = new HashMap<>();
    for (int i = 0; i < products.length; i++)
      map.put(products[i], prices[i]);
  }

  public double getBill(int[] product, int[] amount) {
    double total = 0;
    for (int i = 0; i < product.length; i++)
      total += map.get(product[i]) * amount[i];
    if (current % n == 0) {
      total -= total * discount / 100;
      current = 1;
    } else
      current++;
    return total;
  }
}

/**
 * Your Cashier object will be instantiated and called as such: Cashier obj = new Cashier(n,
 * discount, products, prices); double param_1 = obj.getBill(product,amount);
 */
// @lc code=end

