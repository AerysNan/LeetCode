/*
 * @lc app=leetcode.cn id=736 lang=java
 *
 * [736] Lisp 语法解析
 */

// @lc code=start
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    ArrayList<HashMap<String, Integer>> scope;

    public Solution() {
        scope = new ArrayList<>();
        scope.add(new HashMap<>());
    }

    public int evaluate(String expression) {
        scope.add(new HashMap<>());
        int result = evaluate_inner(expression);
        scope.remove(scope.size() - 1);
        return result;
    }

    public int evaluate_inner(String expression) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-')
                return Integer.parseInt(expression);
            for (int i = scope.size() - 1; i >= 0; --i) {
                if (scope.get(i).containsKey(expression))
                    return scope.get(i).get(expression);
            }
        }
        ArrayList<String> tokens = parse(
                expression.substring(expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        if (expression.startsWith("add", 1))
            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
        else if (expression.startsWith("mult", 1))
            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
        else {
            for (int j = 1; j < tokens.size(); j += 2)
                scope.get(scope.size() - 1).put(tokens.get(j - 1), evaluate(tokens.get(j)));
            return evaluate(tokens.get(tokens.size() - 1));
        }
    }

    public ArrayList<String> parse(String expression) {
        ArrayList<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder buffer = new StringBuilder();
        for (String token : expression.split(" ")) {
            for (char c : token.toCharArray()) {
                if (c == '(')
                    balance++;
                if (c == ')')
                    balance--;
            }
            if (buffer.length() > 0)
                buffer.append(" ");
            buffer.append(token);
            if (balance == 0) {
                result.add(new String(buffer));
                buffer = new StringBuilder();
            }
        }
        if (buffer.length() > 0)
            result.add(new String(buffer));

        return result;
    }
}
// @lc code=end
