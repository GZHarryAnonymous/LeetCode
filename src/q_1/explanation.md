### ��Ŀ��1. Two Sum

###### ����������

- ȷ��һ���������д���������ӵõ�ָ����ֵ��
- ������Ԫ�ز����ظ�ʹ�ã����������Ψһ��

###### ��Ŀ������

- ע������������

###### ��ⷽ����

1. �����ƽ⡣ 
2. ͨ��HashMap������ֵ���±���й������ڹ���������ֱ���жϣ�Map.contains(target-currentElement)

###### �㷨˼�룺

- �ڹ���������ֱ���жϣ�map.contains(target-currentElement)�Ŀ��������ڣ�
- ÿһ���¼����Ԫ�ض�����map�����е�Ԫ�ؽ��бȽϣ����£�
- 1,2,3,4......
- (1,2)
- (1,3),(2,3)
- (1,4),(2,3),(3,4)
- ......

###### ֪ʶ����չ��

- HashMap�Ĵ洢�ṹ������(ɢ��Ͱ)+����
- HashMap��get��������nullʱ���������:getNode(hash(key),key)==null ���� getNode(hash(key),key)!=null����e.value==null(value����putΪ��ֵ)
- containsKey(Object key)ͨ���б�getNode(hash(key),key)�ķ���ֵ��ȷ��keyֵ�Ĵ����ԡ�
- �ڸ���1.8�汾֮�󣬽�������ﵽ8��������תΪ�����������6����ʹ������
- Դ������:

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

###### �ܽ����

- ����=���ݽṹ+�㷨��������˼·�ؼ��������ݽṹ��HashMap�������á�
- HashMap��hashCode�ļ��㷽���������ѧ��������Ȥ�������˽⡣

###### ���˵����

- ����LeetCodeƽ̨�㷨��һ��ˢ���¼��
- �Ѿ�������public repository��[�ֿ�����](https://github.com/GZHarryAnonymous/LeetCode)
- ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
- ���˲��ͣ�[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- ��ӭ���ã���Ȼ��������û����;͸�����������
- �������ޣ�ϣ���аﵽ�㣡