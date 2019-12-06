#
# @lc app=leetcode.cn id=194 lang=bash
#
# [194] 转置文件
#

# @lc code=start
# Read from the file file.txt and print its transposed content to stdout.
awk '{
  for(i=1; i<=NF; i++) {
    if(NR==1)
      s[i] = $i;
    else
      s[i] = s[i] " " $i;
  }
} END {
  for(i=1; i<=NF; i++) {
    print s[i];
  }
}' file.txt
# @lc code=end

