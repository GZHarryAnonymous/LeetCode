### 题目：22. Generate Parentheses

###### 问题描述：

- Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
- For example, given n = 3, a solution set is:

>
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
>

###### 题目分析：

###### 求解方法：

1. 暴力求解
2. 回溯
3. 闭包数

###### 算法思想：

1. pow(2,2n)种可能中逐一判别。
2. 其实就是一棵树，不过生长方式有限定，left(open)能生长就生长，但要满足open_num<=n。right(close)能生长就生长，但要保证close_num<=n且close_num<=open_num。open在前close在后。最后从根节点到每一个叶节点的路径都是一种合理的可能。
3. 如果n=1，那么一定是"()"情况。我们假设generate(j)可以生成左右括号个数都为j的所有合理情况。那么现在:"("+"generate(i)的所有合理情况"+")"+"generate(n-1-i)的所有合理情况"当i从0取到n-1时，就是穷尽所有可能之日。有点数学归纳法的感觉。

###### 知识点扩展：

- 有HashSet和TreeSet都实现了Set接口。
- HashSet由于是集合，所以元素不可以重复，即便是null只能有一个，查找元素的过程是首先计算对象的HashCode值，然后通过HashCode值直接对应到存储该对象的区域调用equals方法进行查找，从而提高了效率。
- Object的equals方法是根据两个对象的内存地址判断两个对象是否相等。所以Set插入Object时，需要重写equals方法，进一步区分内存地址不同但内容相同的“相同”对象。

>
	// 覆写equals方法
	public boolean equals (Object obj){
        // 地址相等，则肯定是同一个对象
        if(this==obj){
            return true;
        }
        // 类型不同，则肯定不是同一类对象
        if(!(obj instanceof Person)){
            return false;
        } 
        // 类型相同，向下转型
        Person per=(Person) obj;
        // 如果两个对象的姓名和性别相同，则是同一个人
        if(this.name.equals(per.name)&&this.sex.equals(per.sex))
            return true;
        return false;
    }
		当然为了保证不同对象有不同的内存地址，需要重写hashCode方法
	 // 覆写hashCode方法  
    public int hashCode(){
			return this.name.hashCode();//name相当于主键哦！
			}
				
>

- 而TreeSet可以自定义Comparator对插入的元素进行相应的排序。		
- 与HashSet完全类似，TreeSet里面绝大部分方法都市直接调用TreeMap方法来实现的。

- 相同点：
- TreeMap和TreeSet都是有序的集合，也就是说他们存储的值都是排好序的。
- TreeMap和TreeSet都是非同步集合，因此他们不能在多线程之间共享，不过可以使用方法。
- Collections.synchroinzedMap()来实现同步。
- 运行速度都要比Hash集合慢，他们内部对元素的操作时间复杂度为O(logN)，而HashMap/HashSet则为O(1)。
- 不同点：
- 最主要的区别就是TreeSet和TreeMap分别实现Set和Map接口。
- TreeSet只存储一个对象，而TreeMap存储两个对象Key和Value（仅仅key对象有序）
- TreeSet中不能有重复对象，而TreeMap中可以存在。
- TreeMap<K,V>是有序的Map，底层使用了红黑树这种数据结构来实现。红黑树是一种应用非常广泛的树结构，在这里先简单说下红黑树这种数据结构相比较其他树类型结构的优缺点：红黑树是一种自平衡的二叉查找树，也叫对称二叉B树，红黑树的查找、插入和删除的时间复杂度都为O(logn)，应用非常广泛。红黑树相对于AVL树（平衡二叉树），牺牲了部分平衡性（红黑树不是完全平衡的二叉树）以换取插入/删除操作时更少的旋转操作，整体在插入/删除的性能上要优于AVL树。所以很多在内存中排序的数据结构都使用红黑树来而不是使用AVL树来存储。红黑树相对于B-树和B+树，相同节点的情况下红黑树由于深度比B-和B+树要深的多，对IO读写非常频繁，所以适合放在内存中的少量读取，而B-和B+树由于每个节点元素非常之多，访问IO的次数就相对少，适合存储在磁盘中的大量数据，类似数据库记录的存储结构。

###### 总结感悟：

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！








