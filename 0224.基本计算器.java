import java.util.Stack;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (31.34%)
 * Total Accepted:    1.3K
 * Total Submissions: 4.2K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 *
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 说明：
 *
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 *
 */
class Solution {
  private int index;

  private boolean isDigit(String s) {
    return s.charAt(index) >= '0' && s.charAt(index) <= '9';
  }

  private void parseSpace(String s) {
    while (index < s.length() && s.charAt(index) == ' ')
      index++;
  }

  private char parseOperator(String s) {
    return s.charAt(index++);
  }

  private int parseInt(String s) {
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

  private int operate(int val1, int val2, char operator) {
    if (operator == '+')
      return val1 + val2;
    return val2 - val1;
  }

  public int calculate(String s) {
    index = 0;
    parseSpace(s);
    if (index == s.length())
      return 0;
    Stack<Integer> valueStack = new Stack<>();
    Stack<Character> operatorStack = new Stack<>();
    while (index < s.length()) {
      if (isDigit(s))
        valueStack.add(parseInt(s));
      else {
        char currentOperator = parseOperator(s);
        if (operatorStack.isEmpty())
          operatorStack.add(currentOperator);
        else {
          switch (currentOperator) {
          case '+':
          case '-': {
            char op = operatorStack.peek();
            if (op == '+' || op == '-') {
              int val1 = valueStack.pop();
              int val2 = valueStack.pop();
              valueStack.add(operate(val1, val2, op));
              operatorStack.pop();
            }
            operatorStack.add(currentOperator);
            break;
          }
          case '(':
            operatorStack.add(currentOperator);
            break;
          case ')': {
            while (true) {
              char op = operatorStack.pop();
              if (op == '(')
                break;
              int val1 = valueStack.pop();
              int val2 = valueStack.pop();
              valueStack.add(operate(val1, val2, op));
            }
            break;
          }
          default:
            break;
          }
        }
      }
      parseSpace(s);
    }
    while (!operatorStack.isEmpty()) {
      char op = operatorStack.pop();
      int val1 = valueStack.pop();
      int val2 = valueStack.pop();
      valueStack.add(operate(val1, val2, op));
    }
    return valueStack.peek();
  }
}
