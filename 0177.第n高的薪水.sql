--
-- @lc app=leetcode.cn id=177 lang=mysql
--
-- [177] 第N高的薪水
--
-- @lc code=start
create function getNthHighestSalary(n int) returns int begin declare m int;
set
  m = n - 1;
return (
    select
      distinct Salary
    from Employee
    order by
      Salary desc
    limit
      m, 1
  );
end;
-- @lc code=end