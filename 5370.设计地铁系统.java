/*
 * @lc app=leetcode.cn id=5370 lang=java
 *
 * [5370] 设计地铁系统
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;

class UndergroundSystem {

  HashMap<Integer, Pair<Integer, String>> map;
  HashMap<String, HashMap<String, LinkedList<Integer>>> time;

  public UndergroundSystem() {
    map = new HashMap<>();
    time = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    map.put(id, new Pair<>(t, stationName));
  }

  public void checkOut(int id, String stationName, int t) {
    Pair<Integer, String> source = map.get(id);
    if (!time.containsKey(source.getValue()))
      time.put(source.getValue(), new HashMap<>());
    HashMap<String, LinkedList<Integer>> temp = time.get(source.getValue());
    if (!temp.containsKey(stationName))
      temp.put(stationName, new LinkedList<>());
    temp.get(stationName).add(t - source.getKey());
  }

  public double getAverageTime(String startStation, String endStation) {
    return time.get(startStation).get(endStation).stream().mapToInt(i -> i).average().getAsDouble();
  }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such: UndergroundSystem obj =
 * new UndergroundSystem(); obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double
 * param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

