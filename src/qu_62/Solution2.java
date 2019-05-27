package qu_62;

import java.util.Arrays;

class Solution2 {
    int dp[][];//=new int[100][100];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][1]=1;
        }
        for(int i=0;i<=n;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public static void main(String args[]){
        Solution2 solve = new Solution2();
        int result = solve.uniquePaths(7,3);
        System.out.println(result);
    }
}
