import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=381 lang=java
 *
 * [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
 */

// @lc code=start
class RandomizedCollection {
  Random random;
  ArrayList<Integer> list;
  HashMap<Integer, LinkedHashSet<Integer>> valToIndices;

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    random = new Random();
    list = new ArrayList<>();
    valToIndices = new HashMap<>();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the
   * specified element.
   */
  public boolean insert(int num) {
    if (!valToIndices.containsKey(num))
      valToIndices.put(num, new LinkedHashSet<>());
    valToIndices.get(num).add(list.size());
    list.add(num);
    return valToIndices.get(num).size() == 1;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  public boolean remove(int num) {
    if (!valToIndices.containsKey(num) || valToIndices.get(num).isEmpty())
      return false;
    int indexToRemove = valToIndices.get(num).iterator().next();
    int valueLast = list.get(list.size() - 1);
    list.set(indexToRemove, valueLast);
    list.remove(list.size() - 1);
    valToIndices.get(num).remove(indexToRemove);
    valToIndices.get(valueLast).add(indexToRemove);
    valToIndices.get(valueLast).remove(list.size());
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    int index = random.nextInt(list.size());
    return list.get(index);
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such: RandomizedCollection
 * obj = new RandomizedCollection(); boolean param_1 = obj.insert(val); boolean param_2 =
 * obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end

