--
-- @lc app=leetcode.cn id=626 lang=mysql
--
-- [626] 换座位
--

-- @lc code=start

# Write your MySQL query statement below

select (
  case
  when mod(id, 2) != 0
    and counts!= id
  then id + 1
  when mod(id, 2) != 0
    and counts = id
  then id
  else id - 1
  end
) as id, student
from seat, (
  select count(*)
  as counts
  from seat
) as b
order by id asc;

-- @lc code=end

