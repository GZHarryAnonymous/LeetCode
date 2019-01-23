### 题目：7. Reverse Integer

###### 问题描述：

- 32-bit signed Integer 反转
- 123变321，-123变-321，120变21

###### 题目分析：

- 2^31-1=2147483647=Integer.MAX_VALUE
- -2^31=-2147483648=Integer.MIX_VALUE
- 判别溢出：
- 对于上界2147483647
- 当前大于等于INTMAX/10，则：
- 当前大于，则下一步溢出。
- 当前等于，则下一步比较个位是否大于7。

###### 求解方法：

- 字符反转
- 题解有使用栈结构的。

###### 算法思想：

- 变成字符串，倒序。
- 后进先出。

###### 知识点扩展：

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！