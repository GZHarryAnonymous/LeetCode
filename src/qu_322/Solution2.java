package qu_322;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);//最多amount个1，所以设置上限为amount+1
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        int[] coins = {1,2,5};
        int result=s.coinChange(coins,11);
        System.out.println(result);    }
}
