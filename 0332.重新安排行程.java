/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    for (List<String> ticket : tickets)
      adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
    visit("JFK", adj, result);
    return result;
  }


  void visit(String src, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> result) {
    while (adj.containsKey(src) && !adj.get(src).isEmpty())
      visit(adj.get(src).poll(), adj, result);
    result.addFirst(src);
  }
}
// @lc code=end

