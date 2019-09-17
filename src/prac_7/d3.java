package prac_7;
import java.util.Arrays;
// 最少钱币个数
public class d3 {
    public static void main(String args[]){
        int total = 100;
        int[] money = {1,2,3,10,20,30};
        int[] dp = new int[total+1];
        Arrays.fill(dp,0);
        for(int i=1;i<=total;i++){
            for(int j=0;j<money.length;j++){
                if(i>=money[j]){
                    if(dp[i]!=0)
                        dp[i]=Math.min(dp[i],dp[i-money[j]]+1);
                    else
                        dp[i]=dp[i-money[j]]+1;
                }
            }
        }
        System.out.println(dp[total]);
    }
}
