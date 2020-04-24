/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {
    double radius, x, y;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double r = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[] { r * Math.cos(theta) + x, r * Math.sin(theta) + y };
    }
}
/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(radius, x_center, y_center); double[] param_1 = obj.randPoint();
 */
// @lc code=end
