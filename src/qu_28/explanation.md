### 题目：28. Implement strStr()

###### 问题描述：

- Input: haystack = "hello", needle = "ll"
- Output: 2
- Input: haystack = "aaaaa", needle = "bba"
- Output: -1
- 返回第一个匹配的模式子串的下标

###### 题目分析：

###### 求解方法：

- Just do it!
- KMP

###### 算法思想：

- 以每一个字符作为字符串的开始字符进行判断，判断过程可以先预判模式串的最后一个字符是否匹配，避免唯有最后字符不匹配的情况，前面的匹配就白玩了。
- KMP算法的核心思想是利用模式串的重复部分，比如abab是模式串，主串是abacabc，那么当模式串的第二次出现的b字符与主串的第一次出现的c字符相遇时，c与b不等，那么模式串直接回退到第一个a，因为对于模式串自身而言，ab与ab是相等的，而主串是无需回退的。

###### 知识点扩展：

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！
