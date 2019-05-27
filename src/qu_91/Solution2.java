package qu_91;

import java.util.Arrays;

public class Solution2 {
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
		return numCal(a,len-1);
	}
	public int numCal(int[] a,int index){
		if(index==0&&a[0]==0)return 0;
		if(index<=0)return 1;
		if(dp[index]>0)return dp[index];
		if(a[index]==0){
			dp[index]=numCal(a,index-2);
			return dp[index];
		}
		if(a[index-1]==0){
			dp[index]=numCal(a,index-3);
			return dp[index];
		}
		if(a[index-1]*10+a[index]<=26){
			dp[index]=numCal(a,index-1)+numCal(a,index-2);
			return dp[index];
		}
		dp[index]=numCal(a,index-1);
		return dp[index];
	}
	public static void main(String[] args){
		Solution2 solve = new Solution2();
		System.out.println(solve.numDecodings("230"));
	}
}
