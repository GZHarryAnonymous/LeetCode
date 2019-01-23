### 题目：5. Longest Palindromic Substring

###### 问题描述：

- 查找给定字符串的最长回文子串。 
- Example 1:
- Input: "babad"
- Output: "bab"
- Note: "aba" is also a valid answer.

###### 题目分析：

- 回文字符串左右对称。是自对称哦！

###### 求解方法：

1. 动态规划
2. 由内而外扩充
3. Manacher

###### 算法思想：

1. 单个字符自对称,p(i,i)=true;if(Si==Si+1)p(i,i+1)=true;p(i,j)=(p(i+1,j-1)andSi==Sj)
2. 当前字符视为可能存在的最长回文字符串的中心。将每一个字符作为中心，向两边扩展。
同时要考虑两个字符同时作为中心的情况。2n-1个字符需要考虑。
3. Manacher:插入字符避开两个相同的挨着，从左到右计算p[i]值用max_right_node覆盖区域找
当前点的对等点，利用已知求未知。

###### 知识点扩展：

- 边界条件的判断。
- 具体方法的抽象与封装。
- char类型比较内容 ==
- substring(int start,int end)是start到end-1

###### 总结感悟：

- 当分析下标时无法确定其规律，可以自己举例验证，实际的例子比抽象的想象更容易。

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！