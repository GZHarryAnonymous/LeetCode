package qu_91;

import java.util.Arrays;

public class Solution3 {
	int[] dp;
	public int numDecodings(String s) {
		int len = s.length();
		if(len<1)return 0;
		int[] a = new int[len];
		dp = new int[len];
		Arrays.fill(dp,-1);
		for(int i=0;i<len;i++){
			a[i] = s.charAt(i)-'0';
			if(i>0&&a[i]==0&&(a[i-1]==0||a[i-1]>2))return 0;
		}
		if(a[0]==0)return 0;
		dp[0]=1;
		for(int i=1;i<len;i++){
			if(a[i]==0){
				if(a[i-1]>2)return 0;
				if(i-2<0)
					dp[i]=dp[0];
				else
					dp[i]=dp[i-2];
			}else{
				if(a[i-1]==0||a[i-1]*10+a[i]>26){
					dp[i]=dp[i-1];
				}else{
					if(i-2<0)
						dp[i]=dp[i-1]+1;
					else
						dp[i]=dp[i-1]+dp[i-2];
				}
			}

		}
		return dp[len-1];
	}
	public static void main(String[] args){
		Solution3 solve = new Solution3();
		System.out.println(solve.numDecodings("230"));
	}
}
