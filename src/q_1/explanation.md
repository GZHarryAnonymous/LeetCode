### 题目：1. Two Sum

###### 问题描述：

- 确定一给定数组中存在两数相加得到指定数值。
- 数组中元素不可重复使用，若解存在则唯一。

###### 题目分析：

- 注意限制条件。

###### 求解方法：

1. 暴力破解。 
2. 通过HashMap将数组值与下标进行关联。在关联过程中直接判断：Map.contains(target-currentElement)

###### 算法思想：

- 在关联过程中直接判断：map.contains(target-currentElement)的可行性在于：
- 每一次新加入的元素都会与map中已有的元素进行比较，如下：
- 1,2,3,4......
- (1,2)
- (1,3),(2,3)
- (1,4),(2,3),(3,4)
- ......

###### 知识点扩展：

- HashMap的存储结构是数组(散列桶)+链表
- HashMap的get方法返回null时有两种情况:getNode(hash(key),key)==null 或者 getNode(hash(key),key)!=null但是e.value==null(value可以put为空值)
- containsKey(Object key)通过判别getNode(hash(key),key)的返回值来确定key值的存在性。
- 在更新1.8版本之后，结点数量达到8个将链表转为红黑树。少于6个则使用链表。
- 源码如下:

>

    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
    
    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }
>

###### 总结感悟：

- 程序=数据结构+算法，该题解的思路关键在于数据结构（HashMap）的运用。
- HashMap中hashCode的计算方法有许多数学机理，感兴趣的自行了解。

###### 相关说明：

- 基于LeetCode平台算法的一个刷题记录！
- 已经共享至public repository：[仓库链接](https://github.com/GZHarryAnonymous/LeetCode)
- 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
- 个人博客：[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- 欢迎来访！当然，如果来访还打赏就更好啦！！！
- 能力有限，希望有帮到你！