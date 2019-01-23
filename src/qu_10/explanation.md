### 题目：10. Regular Expression Matching

###### 问题描述：

- 字符串匹配问题

###### 题目分析：

- text与pattern字符串匹配(完全等价，对等的地位，不是部分的关系)
- text为a-z
- pattern为a-z . *
- .匹配任意单个字母
- X*可以是0个或者多个X
- .*匹配任意，可以理解为任意多个点 ......
- 原字符与匹配字符

###### 求解方法：

- 递归
- 动态规划

###### 算法思想：

- 简单分析如果没有*通配符的情况
- dp(i,j)->dp(i+1)(j+1)
- 递归处理，空，点，按规则（匹配当前或者匹配下一个）一步一步往下走，剩下
一个字符在递归开始的地方处理。
- 考虑所有情况：
- dp(i,j)->dp(i+1)(j+1)当.*代表一个
- dp(i,j)->dp(i)(j+2)当.*代表空
- dp(i,j)->dp(i+1)(j)当.*代表多个
- 动态规划是空间换时间，保存中间状态结果。
- 还有自底向上的动态规划。

###### 知识点扩展：

- 注意："hamburger".substring(4, 8) returns "urge"
4是开始下标，7是结束下标。

- 八大基本数据类型的默认值：
- boolean false
- char '/uoooo'(null)
- byte (byte)0
- short (short)0
- int 0
- long 0L
- float 0.0f
- double 0.0d
- 布尔数组没有赋值也一样。

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！