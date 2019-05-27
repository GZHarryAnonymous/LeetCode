import java.util.Scanner;
import java.util.Vector;
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int row_len = matrix.length;
        if(row_len==0)return 0;//System.out.println(0);
        int col_len = matrix[0].length;
        if(row_len==1){
            for(int i=0;i<col_len;i++){
                if(Integer.parseInt(""+matrix[0][i])==1)return 1;
            }
            return 0;
        }
        if(col_len==0)return 0;//System.out.println(0);
        if(col_len==1)return Integer.parseInt(""+matrix[0][0]);
        int[][] dp = new int[row_len][col_len];
        int result = 0;
        for(int i=0;i<row_len;i++){
            dp[i][0]=Integer.parseInt(""+matrix[i][0]);
            if(dp[i][0]>0)result=1;
        }
        for(int j=0;j<col_len;j++){
            dp[0][j]=Integer.parseInt(""+matrix[0][j]);
            if(dp[0][j]>0)result=1;
        }

        //Solution solve = new Solution();
        for(int i=1;i<row_len;i++){
            //solve.print_matrix(dp);
            //System.out.println();
            for(int j=1;j<col_len;j++){
                if(Integer.parseInt(""+matrix[i][j])==1){
                    //System.out.println("1");
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>result)result=dp[i][j];
            }
        }
        //System.out.println(result*result);
        return result*result;
    }
    public static void main(String[] args){

    }
}