package qu_375;

public class Solution {
	public int getMoneyAmount(int n) {
		if(n<=1)return 0;
		int[][] dp=new int[n+1][n+1];
		int result = removeLeftOrRight(1,n,dp);
		return result;
	}
	public int removeLeftOrRight(int start,int end,int[][] dp){
		if(start>=end)return 0;
		if(dp[start][end]!=0)return dp[start][end];
		dp[start][end]=Integer.MAX_VALUE;
		for(int i=start;i<=end;i++){
			int remainedCost = i+ Math.max(removeLeftOrRight(start,i-1,dp),removeLeftOrRight(i+1,end,dp));
			dp[start][end]=Math.min(remainedCost,dp[start][end]);
		}
		return dp[start][end];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=s.getMoneyAmount(10);
		System.out.println(result);
	}
}

