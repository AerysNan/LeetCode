/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
  public String decodeString(String s) {
    return parse(s, new AtomicInteger(0));
  }

  // "3[a2[c]]"
  String parse(String s, AtomicInteger atomic) {
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      int index = atomic.get();
      if (index == s.length() || s.charAt(index) == ']')
        break;
      char c = s.charAt(index);
      if (Character.isDigit(c)) {
        int count = parseInt(s, atomic);
        atomic.incrementAndGet();
        String encode = parse(s, atomic);
        for (int i = 0; i < count; i++)
          stringBuilder.append(encode);
        atomic.incrementAndGet();
      } else {
        String string = parseString(s, atomic);
        stringBuilder.append(string);
      }
    }
    return stringBuilder.toString();
  }

  int parseInt(String s, AtomicInteger atomic) {
    int index = atomic.get(), end = index;
    while (true) {
      char c = s.charAt(end);
      if (!Character.isDigit(c)) {
        atomic.set(end);
        return Integer.parseInt(s.substring(index, end));
      }
      end++;
    }
  }

  String parseString(String s, AtomicInteger atomic) {
    int index = atomic.get(), end = index;
    while (true) {
      if (end == s.length() || Character.isDigit(s.charAt(end)) || s.charAt(end) == ']') {
        atomic.set(end);
        return s.substring(index, end);
      }
      end++;
    }
  }
}
// @lc code=end

