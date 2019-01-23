### 题目：3. Longest Substring Without Repeating Characters

###### 问题描述：

- 给定一字符串，求最长无重复子串。
- Example 1:
- Input: "abcabcbb"
- Output: 3 
- Explanation: The answer is "abc", with the length of 3. 

###### 题目分析：

- 子序列可以不连续，但子串必须连续。
- 无重复。

###### 求解方法：

1. 暴力破解：遍历每一个子串，通过定义一个函数用于确定当前子串是否有重复的字符。
2. 滑动窗口：构建变量i和j记录子串的始末下标：i，j分别是两个指向，j先一步一步向前走，如果j重复了，则i走一步。
始终关注的点是i到j这个区间的最长无重复子串。进一步的优化，如果j和i到j区间的某一个k点重复了，则i可以直接跨步到k+1。

###### 算法思想：

- 滑动的窗口是一个形象的比喻，或者你可以把i到j想象成是橡皮筋的两端，不重复是橡皮筋弹性拉伸的前提，而回弹的步长可以是一步一个脚印，但也可以跨步向前。具体问题具体分析。
- 在实践过程中，有一个很重要的点就是将字符与其对应下标进行一一映射，而关联的方法不唯一：可以采用HashMap、HashSet和ASCII（int[] index = new int[128];数组的下标对应字符的ASCII，而数组值对应字符在字符串中的位置下标）.

###### 知识点扩展：

1. 依赖倒置原则：依赖抽象，不依赖具体，所以变量声明可以用Map<Character, Integer> map = new HashMap<>();
2. HashMap中使用的泛型需要是包装类，不可以是基本数据类型。因为基本数据类型没有继承Object类，没有方法，当然也无法调用hashcode()方法和equals()方法。而包装类是继承Object类的。
3. 特别的，当HashMap存储自定义对象的时候，需要按照自己的需求重写hashcode()和equal()方法。否则，每new一次就创建一个新的对象，面对相同对象（仅引用不同）的情况，导致HashMap存储重复值。详解见hashcode源码。
3. HashMap实现Map接口，存储键值对，使用put和get方法，使用key计算hashcode值，速度稍快。
4. HashSet实现Set接口，仅存储对象，使用add和remove方法，使用成员对象计算hashcode，速度稍慢。
5. 相关源码如下：

>
	
	 public boolean equals(Object obj) {
        return (this == obj);
    }
    
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map))
            return false;
        Map<?,?> m = (Map<?,?>) o;
        if (m.size() != size())
            return false;
        try {
            Iterator<Entry<K,V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(m.get(key)==null && m.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(m.get(key)))
                        return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
        return true;
    }
    
>

###### 总结感悟：

- Java的好处是封装，而且有人帮你封装，你可以直接用一些方法。坏处是被封装的方法不是你自己写的。

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！