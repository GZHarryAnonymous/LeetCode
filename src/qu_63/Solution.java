package qu_63;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m < 1) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		if (n < 1) {
			return 0;
		}
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			if (obstacleGrid[i-1][0] != 1) {
				dp[i][1] = 1;
			} else {
				//dp[i][1] = 0;
				break;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (obstacleGrid[0][i-1] != 1) {
				dp[1][i] = 1;
			} else {
				//dp[1][i] = 0;
				break;
			}
		}
		for(int i=2;i<=m;i++){
			for(int j=2;j<=n;j++){
				if(obstacleGrid[i-1][j-1]!=1){
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}else{
					dp[i][j]=0;
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}

