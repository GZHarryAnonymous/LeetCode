### 题目：26. Remove Duplicates from Sorted Array

###### 问题描述：

- 去除给定整形有序数组的重复元素。并返回新数组的元素个数。
- 必须在给定数组上进行操作。
- 假设新数组长度为n，那么前n个元素各不相同且无需关注新数组n个元素之后的值如何。

###### 题目分析：

###### 求解方法：

###### 算法思想：

- 利用有序性质，变量index记录不重复的数组长度（即新数组有效范围），遍历数组元素，若与当前num[index]不等，则加入有效数组。index始终记录有效数组的末端元素。
因为有序，所以下一个出现的重复元素一定是和num[index]相等的情况。

###### 知识点扩展：

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！