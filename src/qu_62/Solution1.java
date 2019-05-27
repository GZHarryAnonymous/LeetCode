package qu_62;

import java.util.Arrays;

class Solution1 {
    int dp[][];//=new int[100][100];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return Cal(m,n);
    }
    public int Cal(int m,int n){
        if(m==1||n==1)return 1;
        if(dp[m][n]>0)return dp[m][n];
        dp[m][n]=Cal(m-1,n)+Cal(m,n-1);
        return dp[m][n];
    }
    public static void main(String args[]){
        Solution1 solve = new Solution1();
        int result = solve.uniquePaths(7,3);
        System.out.println(result);
    }
}
