/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
import java.util.Stack;

class Solution {
  private int index;
  private String s;
  Stack<Integer> valueStack = new Stack<>();
  Stack<Character> operatorStack = new Stack<>();

  private boolean isDigit() {
    return s.charAt(index) >= '0' && s.charAt(index) <= '9';
  }

  private void parseSpace() {
    while (index < s.length() && s.charAt(index) == ' ')
      index++;
  }

  private char parseOperator() {
    return s.charAt(index++);
  }

  private int parseInt() {
    int value = 0;
    while (index < s.length()) {
      char c = s.charAt(index);
      if (c >= '0' && c <= '9') {
        value = value * 10 + c - '0';
        index++;
      } else
        break;
    }
    return value;
  }

  private void step() {
    int val1 = valueStack.pop(), val2 = valueStack.pop();
    valueStack.add(operate(val1, val2, operatorStack.pop()));
  }


  private int operate(int val1, int val2, char operator) {
    switch (operator) {
      case '+':
        return val2 + val1;
      case '-':
        return val2 - val1;
      case '*':
        return val2 * val1;
      case '/':
        return val2 / val1;
      default:
        return 0;
    }
  }

  public int calculate(String s) {
    index = 0;
    this.s = s;
    parseSpace();
    if (index == s.length())
      return 0;
    while (index < s.length()) {
      if (isDigit())
        valueStack.add(parseInt());
      else {
        char currentOperator = parseOperator();
        if (operatorStack.isEmpty())
          operatorStack.add(currentOperator);
        else {
          switch (currentOperator) {
            case '+':
            case '-': {
              while (true) {
                if (operatorStack.isEmpty())
                  break;
                char op = operatorStack.peek();
                if (op == '+' || op == '-' || op == '*' || op == '/')
                  step();
                else
                  break;
              }
              operatorStack.add(currentOperator);
              break;
            }
            case '*':
            case '/':
              while (true) {
                if (operatorStack.isEmpty())
                  break;
                char op = operatorStack.peek();
                if (op == '*' || op == '/')
                  step();
                else
                  break;
              }
              operatorStack.add(currentOperator);
              break;
            case '(':
              operatorStack.add(currentOperator);
              break;
            case ')': {
              while (true) {
                char operator = operatorStack.pop();
                if (operator == '(')
                  break;
                int val1 = valueStack.pop(), val2 = valueStack.pop();
                valueStack.add(operate(val1, val2, operator));
              }
              break;
            }
            default:
              break;
          }
        }
      }
      parseSpace();
    }
    while (!operatorStack.isEmpty()) {
      char op = operatorStack.pop();
      int val1 = valueStack.pop(), val2 = valueStack.pop();
      valueStack.add(operate(val1, val2, op));
    }
    return valueStack.peek();
  }
}
// @lc code=end

