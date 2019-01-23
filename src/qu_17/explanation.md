### 题目：17. Letter Combinations of a Phone Number

###### 问题描述：

- 计算器(3乘以3)，1不映射。2映射（abc），3映射（def）以此类推，9映射（wxyz）。
- 给定"23"
- 输出["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

###### 题目分析：

###### 求解方法：

- 递归

###### 算法思想：

- 每一次递归取一个数字对应的字母串进行遍历，并将其与上一层的字符串拼接。
- 最终递归过程实现了一棵树，每一层都是上一层针对下一个字母串的延拓。
- root根节点，下一个字母串(abc)
- a b c树的第一层，下一个字符串(def)
- ad ae af bd be bf cd ce cf
- ......

###### 知识点扩展：

- 如果if能解决，就不要加else。

###### 总结感悟：

- 一生二，二生四，。。。。有点易经的味道，树结构是真的不简单！

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！