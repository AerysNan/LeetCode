#
# @lc app=leetcode.cn id=193 lang=bash
#
# [193] 有效电话号码
#

# @lc code=start
# Read from the file file.txt and output all valid phone numbers to stdout.
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
# @lc code=end

