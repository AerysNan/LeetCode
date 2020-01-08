import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
  HashMap<Integer, Integer> map;
  ArrayList<Integer> list;
  Random random;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    random = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (map.containsKey(val))
      return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val))
      return false;
    int index = map.remove(val), last = list.remove(list.size() - 1);
    if (val != last) {
      list.set(index, last);
      map.put(last, index);
    }
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
// @lc code=end

