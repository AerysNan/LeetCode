/*
 * @lc app=leetcode.cn id=1169 lang=java
 *
 * [1169] 查询无效交易
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Transaction {
  String name;
  Integer time;
  Integer money;
  String city;

  public Transaction(String name, Integer time, Integer money, String city) {
    this.name = name;
    this.time = time;
    this.money = money;
    this.city = city;
  }

  static Transaction fromStirng(String s) {
    String[] strings = s.split(",");
    return new Transaction(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]),
        strings[3]);
  }
}


class Solution {
  public List<String> invalidTransactions(String[] transactions) {
    List<Transaction> list = Arrays.stream(transactions).map(s -> Transaction.fromStirng(s))
        .collect(Collectors.toList());
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      Transaction t = list.get(i);
      if (t.money > 1000)
        result.add(transactions[i]);
      else {
        for (Transaction u : list) {
          if (t != u && u.name.equals(t.name) && !u.city.equals(t.city)
              && Math.abs(u.time - t.time) <= 60) {
            result.add(transactions[i]);
            break;
          }
        }
      }
    }
    return result;
  }
}
// @lc code=end

