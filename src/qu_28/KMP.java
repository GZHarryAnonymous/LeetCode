package qu_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
class KMP {
	private int[] getNext(String p) {//ģʽ���Լ����Լ��Ƚ�
		int len = p.length(),step=0;
		int[] next=new int[len];
		next[0] = 0;
		for(int i=1;i<len;i++) {
			while(step>0&&p.charAt(step)!=p.charAt(i)) {//Ԥ����һ���ַ��Ƿ����
				step=next[step-1];//����������
			}
			if(p.charAt(step)==p.charAt(i)) {
				step++;//��������ǰ׺�ַ������ȼ�һ�����ǰ׺�ַ����ǵ�������׺�ַ�����
			}
			next[i]=step;//��¼����ǰ�ַ�Ϊֹ�����ǰ׺�ַ���������׺�ַ����ĳ���ֵ
		}
		return next;
	}
	private int KMP_MATCHER(String T,String P) {
		int P_len=P.length();
		if(P_len==0)return 0;
		int T_len=T.length();
		if(T_len<P_len)return -1;
		if(P_len==1) {
			for(int i=0;i<T_len;i++) {
				if(T.charAt(i)==P.charAt(0))return i;
			}
			return -1;
		};
		int[] next=getNext(P);//�õ�ģʽ��next����
		int step=0;
		for(int i=-1;i<T_len-1;i++) {
			while(step>0&&P.charAt(step)!=T.charAt(i+1)) {//ע�������±����⣬�����±��Ǵ�0��ʼ�ģ��Ҳ�����С����
				step=next[step-1];//step�����ǰ׺�ַ�������һ���ַ���i+1������׺�ַ�������һ���ַ�
			}//һ��α��ʵ�ַ�����1��ʼ
			if(P.charAt(step)==T.charAt(i+1))step++;
			if(step==P_len) {
				System.out.println("Pattern occurs with shift"+(i-P_len+2));
				step=0;
				return i-P_len+2;//i+1-(P_len-1)
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		KMP ttt = new KMP();
		String t="aaab";
		String p="aab";
		int[] result=ttt.getNext(p);
		for(int c:result) {
			System.out.println(c);
		}
		System.out.println(ttt.KMP_MATCHER(t,p));
	}
}