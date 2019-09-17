package qu_343;

public class Solution {
	public int integerBreak(int n) {//n>=2 <=58
		int[] result=new int[11];
		result[0]=0;
		result[1]=0;
		result[2]=1;
		result[3]=2;
		//3以下不要继续分
		result[4]=4;
		result[5]=6;
		result[6]=9;
		result[7]=12;
		result[8]=18;
		result[9]=27;
		result[10]=36;
		//dp[11]=48;
		//dp[12]=81;
		//dp[13]=dp[3]*dp[10]=108;
		if(n<11)return result[n];
		int[] dp = new int[n+1];
		dp[8]=18;
		dp[9]=27;
		dp[10]=36;
		for(int i=11;i<=n;i++){
			dp[i]=dp[i-3]*3;
		}
		return dp[n];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=s.integerBreak(11);
		System.out.println(result);
	}
}

