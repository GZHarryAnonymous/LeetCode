### ��Ŀ��13. Roman to Integer

###### ����������

- ��������ת����������
- �������������������ֹ�ϵ(I:1,V:5,X:10,L:50,C:100,D:500,M:1000)
- ����Ҽ�ԭ��(IV=5-1=4,IX=10-1=9,LVIII=50+5+3=58)
- VIII=8û���⣬����VIIII�ǲ��ܱ�ʾ9�ģ�Ӧ����IX=9.ͬ����IV=4,XL=40,CD=400,CM=900


###### ��Ŀ������

- 1994=1000+(1000-100)+(100-10)+(5-1)=MCMXCIV 

###### ��ⷽ����

- MCMXCIV=1000+(1000-100)+(100-10)+(5-1)=1994

###### �㷨˼�룺

- ��ǰС�ں�һ�����ȥ��ǰֵ����ǰ���ں�һ������ϡ�
- �߼��е�switch case����ʹ��HashMap�����һ���Ż���

###### ֪ʶ����չ��

- �ַ���������

>
	s="abc"
	for(int i=0;i<s.length();i++){
		System.out.println(s.charAt(i));}
>

- ���ɵ���Ĵ��벻Ҫд

>
	return 0;
	break;  //This Line: error: unreachable statement
>

- �ַ������飺

>
	String[] s1={"a","b","c","d","e"};
	for(int i=0;i<s1.length;i++){
		System.out.print(s1[i]+" ");//���a b c d e����ȡ�ַ�������
		}
		String[] s2={"abcde"};
		System.out.println(s2.length);//���1��ֻ�ǳ���Ϊ1�����飬������5
		for(int i=0;i<s2.length;i++){
			System.out.print(s2[i]+" k");//���abcde k
			}
>

###### �ܽ����

###### ���˵����

- ����LeetCodeƽ̨�㷨��һ��ˢ���¼��
- �Ѿ�������public repository��[�ֿ�����](https://github.com/GZHarryAnonymous/LeetCode)
- ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
- ���˲��ͣ�[GZHarryAnonymous](https://gzharryanonymous.github.io/)
- ��ӭ���ã���Ȼ��������û����;͸�����������
- �������ޣ�ϣ���аﵽ�㣡