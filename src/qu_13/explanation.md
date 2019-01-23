### 题目：13. Roman to Integer

###### 问题描述：

- 罗马数字转阿拉伯数字
- 阿拉伯数字与罗马数字关系(I:1,V:5,X:10,L:50,C:100,D:500,M:1000)
- 左减右加原则(IV=5-1=4,IX=10-1=9,LVIII=50+5+3=58)
- VIII=8没问题，但是VIIII是不能表示9的，应该是IX=9.同理有IV=4,XL=40,CD=400,CM=900


###### 题目分析：

- 1994=1000+(1000-100)+(100-10)+(5-1)=MCMXCIV 

###### 求解方法：

- MCMXCIV=1000+(1000-100)+(100-10)+(5-1)=1994

###### 算法思想：

- 当前小于后一个则减去当前值，当前大于后一个则加上。
- 逻辑中的switch case可以使用HashMap代替进一步优化。

###### 知识点扩展：

- 字符串遍历：

>
	s="abc"
	for(int i=0;i<s.length();i++){
		System.out.println(s.charAt(i));}
>

- 不可到达的代码不要写

>
	return 0;
	break;  //This Line: error: unreachable statement
>

- 字符串数组：

>
	String[] s1={"a","b","c","d","e"};
	for(int i=0;i<s1.length;i++){
		System.out.print(s1[i]+" ");//输出a b c d e，获取字符串数组
		}
		String[] s2={"abcde"};
		System.out.println(s2.length);//输出1，只是长度为1的数组，并不是5
		for(int i=0;i<s2.length;i++){
			System.out.print(s2[i]+" k");//输出abcde k
			}
>

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！