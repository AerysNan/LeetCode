/*
 * @lc app=leetcode.cn id=592 lang=java
 *
 * [592] 分数加减运算
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
    public String fractionAddition(String expression) {
        ArrayList<Character> sign = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++)
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> den = new ArrayList<>();
        for (String sub : expression.split("\\+")) {
            for (String subsub : sub.split("-")) {
                if (subsub.length() > 0) {
                    String[] fraction = subsub.split("/");
                    num.add(Integer.parseInt(fraction[0]));
                    den.add(Integer.parseInt(fraction[1]));
                }
            }
        }
        if (expression.charAt(0) == '-')
            num.set(0, -num.get(0));
        int lcm = 1;
        for (int x : den)
            lcm = lcm(lcm, x);
        int result = lcm / den.get(0) * num.get(0);
        for (int i = 1; i < num.size(); i++) {
            if (sign.get(i - 1) == '+')
                result += lcm / den.get(i) * num.get(i);
            else
                result -= lcm / den.get(i) * num.get(i);
        }
        int g = gcd(Math.abs(result), Math.abs(lcm));
        return (result / g) + "/" + (lcm / g);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
// @lc code=end
