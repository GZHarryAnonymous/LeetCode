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
	private int[] getNext(String p) {//模式串自己与自己比较
		int len = p.length(),step=0;
		int[] next=new int[len];
		next[0] = 0;
		for(int i=1;i<len;i++) {
			while(step>0&&p.charAt(step)!=p.charAt(i)) {//预判下一个字符是否相等
				step=next[step-1];//不相等则回溯
			}
			if(p.charAt(step)==p.charAt(i)) {
				step++;//相等则最长真前缀字符串长度加一，最长真前缀字符串是等于最长真后缀字符串的
			}
			next[i]=step;//记录到当前字符为止，最长真前缀字符串与最长真后缀字符串的长度值
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
		int[] next=getNext(P);//得到模式串next数组
		int step=0;
		for(int i=-1;i<T_len-1;i++) {
			while(step>0&&P.charAt(step)!=T.charAt(i+1)) {//注意数组下标问题，数组下标是从0开始的，且不可以小于零
				step=next[step-1];//step是最长真前缀字符串的下一个字符，i+1是最长真后缀字符串的下一个字符
			}//一般伪码实现分析用1开始
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