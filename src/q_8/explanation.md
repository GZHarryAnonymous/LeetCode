### 题目：8. String to Integer (atoi)

###### 问题描述：

- 字符串转整形对象

###### 题目分析：

- ' '过
- 遇到第一个非空格且非数字，停
- 超过INT_MAX或者超过INT_MIN，返回INT_MAX或者超过INT_MIN
- 若第一个非空格且非数字，返回0

###### 求解方法：

- 可以将字符串中字符转化为整形的类型
- Integer.parseInt(str.substring(i,i+1))
- str.charAt(i)-'0'

###### 算法思想：

###### 知识点扩展：

- java中没有typeof
- 只有instanceof
- java中要使用反射：str.getClass()判别类类型
- char是基本数据类型，两个字节，底层存储为Unicode字符集
- Character是char的包装类，其可以调用getClass()等方法
- 基本数据类型是没有方法的

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！