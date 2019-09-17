package qu_72;
// word1 = "horse", word2 = "ros"
// Output: 3
// 相同顺序字符：os或者rs
// 去掉rs，剩下：hoe、o，则3>1，所以 output：3
public class Solution {
	public int minDistance(String word1, String word2) {
		int m=word1.length();
		int n=word2.length();
		if(m==0)return n;
		if(n==0)return m;
		int[][] dp = new int[m+1][n+1];
		dp[0][0]=0;
		for(int i=1;i<=m;i++){
			dp[i][0]=i;
		}
		for(int j=1;j<=n;j++){
			dp[0][j]=j;
		}
		for(int j=1;j<=n;j++){
			for(int i=1;i<=m;i++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					// dp[i][j]=dp[i-1][j-1]+1;
					dp[i][j]=dp[i-1][j-1];// 相同的话
				}else{
					// dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); // 求相同字符的个数
					dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;// 不相同的话
				}
			}
		}
		// Math.max(m,n)-dp[m][n]
		return dp[m][n];
	}
	public static void main(String args[]) {
		Solution solve = new Solution();
		String word1 = "intention";
		String word2 = "execution";
		word1 = "horse";
		word2 = "ros";
		int result=solve.minDistance(word1,word2);
		System.out.println(result);
	}
}

