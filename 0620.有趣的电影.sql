--
-- @lc app=leetcode.cn id=620 lang=mysql
--
-- [620] 有趣的电影
--

-- @lc code=start
# Write your MySQL query statement below

select *
from cinema
where mod(id, 2) = 1 and description != 'boring'
order by rating desc

-- @lc code=end

