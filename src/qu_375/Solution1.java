package qu_375;

public class Solution1 {
	public int getMoneyAmount(int n) {
		if(n<=1)return 0;
		int[][] dp=new int[n+1][n+1];
		for(int end=1;end<=n;end++){
			for(int start=end-1;start>=1;start--){
				int maxCost=0,result=Integer.MAX_VALUE;
				for(int k=start+1;k<end;k++){
					maxCost=k+Math.max(dp[start][k-1],dp[k+1][end]);
					result=Math.min(result,maxCost);
				}
				dp[start][end]=start==end-1?start:result;
			}
		}
		return dp[1][n];
	}

	public static void main(String args[]) {
		Solution1 s = new Solution1();
		int result=s.getMoneyAmount(10);
		System.out.println(result);
	}
}

