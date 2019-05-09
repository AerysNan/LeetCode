import java.util.ArrayList;

/*
* @lc app=leetcode.cn id=1106 lang=java
*
* [1106] 解析布尔表达式
*/

class Solution {
  int index;
  String expression;

  class Expression {
    ArrayList<Expression> expressions;
    int op; // not:0 and:1 or:2
    boolean terminal;
    boolean value;

    public Expression(ArrayList<Expression> expressions, int op) {
      this.expressions = expressions;
      this.op = op;
      this.terminal = false;
    }

    public Expression(boolean value) {
      this.value = value;
      this.terminal = true;
    }
  }

  public boolean parseBoolExpr(String expression) {
    index = 0;
    this.expression = expression;
    return evalExpr(parseExpression());
  }

  public Expression parseExpression() {
    char c = expression.charAt(index);
    Expression subExpr = null;
    switch (c) {
    case '!':
      parseChar('!');
      parseChar('(');
      subExpr = new Expression(parserExpressionList(), 0);
      parseChar(')');
      break;
    case '&':
      parseChar('&');
      parseChar('(');
      subExpr = new Expression(parserExpressionList(), 1);
      parseChar(')');
      break;
    case '|':
      parseChar('|');
      parseChar('(');
      subExpr = new Expression(parserExpressionList(), 2);
      parseChar(')');
      break;
    default:
      subExpr = new Expression(parseBool());
    }
    return subExpr;
  }

  public boolean parseBool() {
    char c = expression.charAt(index);
    if (c == 't') {
      parseChar('t');
      return true;
    }
    parseChar('f');
    return false;
  }

  public ArrayList<Expression> parserExpressionList() {
    ArrayList<Expression> expressionList = new ArrayList<>();
    expressionList.add(parseExpression());
    while (expression.charAt(index) == ',') {
      parseChar(',');
      expressionList.add(parseExpression());
    }
    return expressionList;
  }

  public void parseChar(char c) {
    if (expression.charAt(index) == c) {
      index++;
      return;
    }
    System.exit(-1);
  }

  public boolean evalExpr(Expression e) {
    if (e.terminal)
      return e.value;
    boolean value = false;
    switch (e.op) {
    case 0:
      value = !evalExpr(e.expressions.get(0));
      break;
    case 1:
      value = true;
      for (Expression subExpr : e.expressions)
        value = value && evalExpr(subExpr);
      break;
    case 2:
      value = false;
      for (Expression subExpr : e.expressions)
        value = value || evalExpr(subExpr);
      break;
    }
    return value;
  }
}
