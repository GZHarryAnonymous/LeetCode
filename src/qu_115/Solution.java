package qu_115;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	int dp[][];
	public int numDistinct(String s, String t) {
		int s_len = s.length();
		int t_len = t.length();
		if(s_len<t_len)return 0;
		dp = new int[s_len][t_len];
		for(int i=0;i<s_len;i++){
			Arrays.fill(dp[i],-1);
		}
		int result = cal(s,s_len-1,t,t_len-1);
		return result;
	}
	public int cal(String s,int s_end,String t,int t_end){
		//System.out.println(s.substring(0,s_end+1));
		//System.out.println(t.substring(0,t_end+1));

		if(s_end<t_end){
			//dp[s_end][t_end]=0;
			return 0;//dp[s_end][t_end];
		}
		//if(t_end == 0 && t.charAt(t_end)==s.charAt(s_end))return 1;
		if(t_end<0){
			//dp[s_end][t_end]=1;
			return 1;//dp[s_end][t_end];
		}
		if(dp[s_end][t_end]>-1)return dp[s_end][t_end];
		while(s.charAt(s_end)!=t.charAt(t_end)){
			s_end--;
			if(s_end<t_end)return 0;
		}
		dp[s_end][t_end] = cal(s,s_end-1,t,t_end-1)+cal(s,s_end-1,t,t_end);
		return dp[s_end][t_end];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		//String a = sc.next();
		//String b = sc.next();
		String a = "babgbag";
		String b = "bag";
		int result=s.numDistinct(a,b);
		System.out.println(result);
	}
}
//S = "rabbbit", T = "rabbit"
//3
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
