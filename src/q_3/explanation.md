### ��Ŀ��3. Longest Substring Without Repeating Characters

###### ����������

- ����һ�ַ�����������ظ��Ӵ���
- Example 1:
- Input: "abcabcbb"
- Output: 3 
- Explanation: The answer is "abc", with the length of 3. 

###### ��Ŀ������

- �����п��Բ����������Ӵ�����������
- ���ظ���

###### ��ⷽ����

1. �����ƽ⣺����ÿһ���Ӵ���ͨ������һ����������ȷ����ǰ�Ӵ��Ƿ����ظ����ַ���
2. �������ڣ���������i��j��¼�Ӵ���ʼĩ�±꣺i��j�ֱ�������ָ��j��һ��һ����ǰ�ߣ����j�ظ��ˣ���i��һ����
ʼ�չ�ע�ĵ���i��j������������ظ��Ӵ�����һ�����Ż������j��i��j�����ĳһ��k���ظ��ˣ���i����ֱ�ӿ粽��k+1��

###### �㷨˼�룺

- �����Ĵ�����һ������ı�������������԰�i��j���������Ƥ������ˣ����ظ�����Ƥ��������ǰ�ᣬ���ص��Ĳ���������һ��һ����ӡ����Ҳ���Կ粽��ǰ������������������
- ��ʵ�������У���һ������Ҫ�ĵ���ǽ��ַ������Ӧ�±����һһӳ�䣬�������ķ�����Ψһ�����Բ���HashMap��HashSet��ASCII��int[] index = new int[128];������±��Ӧ�ַ���ASCII��������ֵ��Ӧ�ַ����ַ����е�λ���±꣩.

###### ֪ʶ����չ��

1. ��������ԭ���������󣬲��������壬���Ա�������������Map<Character, Integer> map = new HashMap<>();
2. HashMap��ʹ�õķ�����Ҫ�ǰ�װ�࣬�������ǻ����������͡���Ϊ������������û�м̳�Object�࣬û�з�������ȻҲ�޷�����hashcode()������equals()����������װ���Ǽ̳�Object��ġ�
3. �ر�ģ���HashMap�洢�Զ�������ʱ����Ҫ�����Լ���������дhashcode()��equal()����������ÿnewһ�ξʹ���һ���µĶ��������ͬ���󣨽����ò�ͬ�������������HashMap�洢�ظ�ֵ������hashcodeԴ�롣
3. HashMapʵ��Map�ӿڣ��洢��ֵ�ԣ�ʹ��put��get������ʹ��key����hashcodeֵ���ٶ��Կ졣
4. HashSetʵ��Set�ӿڣ����洢����ʹ��add��remove������ʹ�ó�Ա�������hashcode���ٶ�������
5. ���Դ�����£�

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

###### �ܽ����

- Java�ĺô��Ƿ�װ���������˰����װ�������ֱ����һЩ�����������Ǳ���װ�ķ����������Լ�д�ġ�

###### ���˵����

- ����LeetCodeƽ̨�㷨��һ��ˢ���¼��
- �Ѿ�������public repository��[�ֿ�����](https://github.com/GZHarryAnonymous/LeetCode)
- ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
- ���˲��ͣ�[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- ��ӭ���ã���Ȼ��������û����;͸�����������
- �������ޣ�ϣ���аﵽ�㣡