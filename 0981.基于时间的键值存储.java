/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
  HashMap<String, TreeMap<Integer, String>> map;

  /** Initialize your data structure here. */
  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key))
      return "";
    Map.Entry<Integer, String> e = map.get(key).floorEntry(timestamp);
    return e == null ? "" : e.getValue();
  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
// @lc code=end
