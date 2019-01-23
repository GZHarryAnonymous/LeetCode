### 题目：30. Substring with Concatenation of All Words

###### 问题描述：

- 给定一个字符串和一个字符串数组。
- 字符串数组中每一个单词长度相同（字符个数一样）。
- 查看字符串中是否存在子串刚好由所有单词组成。
- 如果存在返回下标。
- 举例：
- Input:
- s = "barfoothefoobarman",
- words = ["foo","bar"]
- Output: [0,9]

###### 题目分析：

###### 求解方法：

- 滑动窗口

###### 算法思想：

- s = "barfoothefoobarman"
- words = ["foo","bar"]words中的word长度是相同的。
- words中的单词是可以重复出现的。比如：words = ["foo","bar","foo"]
- s中存在words中的组合。
- 首先每回走一个字符在s中，然后用hashMap记录words中特定单词出现的次数。
- 但此种方法效率低下。
- 或者，每回走一个word，走word.length()回，这样就可以重复利用啦！
- 只需要考虑新进的单词和后加的单词的差异，借助之前的分析。
- 详解见代码。

###### 知识点扩展：

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！