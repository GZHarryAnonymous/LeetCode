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
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/
