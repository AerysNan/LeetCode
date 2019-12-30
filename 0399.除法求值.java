/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

class Edge {
  String src, trg;
  double weight;

  Edge(String src, String trg, double weight) {
    this.src = src;
    this.trg = trg;
    this.weight = weight;
  }
}


class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
    int n = values.length;
    for (int i = 0; i < n; i++) {
      String p1 = equations.get(i).get(0), p2 = equations.get(i).get(1);
      double weight = values[i];
      if (!graph.containsKey(p1))
        graph.put(p1, new ArrayList<>());
      graph.get(p1).add(new Edge(p1, p2, weight));
      if (!graph.containsKey(p2))
        graph.put(p2, new ArrayList<>());
      graph.get(p2).add(new Edge(p2, p1, 1 / weight));
    }
    n = queries.size();
    double[] result = new double[n];
    for (int i = 0; i < n; i++) {
      String src = queries.get(i).get(0), trg = queries.get(i).get(1);
      if(!graph.containsKey(src)||!graph.containsKey(trg)){
        result[i] = -1.0;
        continue;
      }
      result[i] = search(src, trg, graph);
    }
    return result;
  }

  double search(String src, String trg, HashMap<String, ArrayList<Edge>> graph) {
    Queue<Pair<String, Double>> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    visited.add(src);
    queue.add(new Pair<>(src, 1.0));
    while (!queue.isEmpty()) {
      Pair<String, Double> p = queue.poll();
      String key = p.getKey();
      double value = p.getValue();
      if (key.compareTo(trg) == 0)
        return value;
      if (!graph.containsKey(key))
        continue;
      ArrayList<Edge> edges = graph.get(key);
      for (Edge edge : edges) {
        if (visited.contains(edge.trg))
          continue;
        visited.add(edge.trg);
        queue.add(new Pair<>(edge.trg, value * edge.weight));
      }
    }
    return -1.0;
  }
}
// @lc code=end

