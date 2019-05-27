package qu_322;

import java.util.Arrays;
import java.util.Comparator;

class myComparator implements Comparator<Integer> {
	public int compare(Integer a,Integer b){
		//if(a>b)return -1;
		//else if(a<b) return 1;
		//return 0;
        return b-a;
	}
}
public class Solution {

	public int coinChange(int[] coins, int amount) {
		int len = coins.length;
		if(len==0)return -1;
		if(len==1&&amount%coins[0]==0)return amount/coins[0];
		//myComparator big_to_small = new myComparator();
        Arrays.sort(coins);
		int[] dp = new int[amount+1];
		for(int i=0;i<len;i++){
		    int num = 0,remainder = amount;
			while(remainder>=coins[i]){
				remainder-=coins[i];
				num++;
				dp[amount-remainder] = num;
			}
		}
		//int result = backTrackCoinKind(coins,dp,amount,Integer.MAX_VALUE);
		int result =0;
        return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] coins = {186,419,83,408};
		int result=s.coinChange(coins,6249);
		System.out.println(result);
	}
}
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/