--
-- @lc app=leetcode.cn id=627 lang=mysql
--
-- [627] 交换工资
--

-- @lc code=start
# Write your MySQL query statement below

update salary
set sex =
  case sex
    when 'm' then 'f'
    else 'm'
  end;

-- @lc code=end

