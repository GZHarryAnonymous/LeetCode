### 题目：25. Reverse Nodes in k-Group

###### 问题描述：

- 给定一个链表，K临近节点反转。
- Given this linked list: 1->2->3->4->5
- For k = 2, you should return: 2->1->4->3->5
- For k = 3, you should return: 3->2->1->4->5

###### 题目分析：

- 审题很重要，比如此题的step不够不予以处理。即：k=3情况，4和5不予处理。
- 不可以链表节点不动仅仅交换值，应该移动链表的结构达到交换。

###### 求解方法：

- 递归，链表n步长倒置。

###### 算法思想：

###### 知识点扩展：

###### 总结感悟：

- 递归方法编程过程中边界条件应该先确定。
- 及时返回以绝后患是优化的可能之一。

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！